package com.hexaware.cozyhaven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.hexaware.cozyhaven.dto.BookingDTO;
import com.hexaware.cozyhaven.dto.RoomAvailabilityDTO;
import com.hexaware.cozyhaven.model.Booking;
import com.hexaware.cozyhaven.model.HotelInfo;
import com.hexaware.cozyhaven.model.Payment;
import com.hexaware.cozyhaven.model.Refund;
import com.hexaware.cozyhaven.repository.BookingRepository;
import com.hexaware.cozyhaven.repository.HotelInfoRepository;
import com.hexaware.cozyhaven.repository.PaymentRepository;
import com.hexaware.cozyhaven.repository.RefundRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private HotelInfoService hotelInfoService;
    
    @Autowired
    private HotelInfoRepository hotelInfoRepo;
    
    @Autowired
    private PaymentRepository paymentRepo;
    
    @Autowired
    private RefundRepository refundRepo;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    
    public List<RoomAvailabilityDTO> getRoomAvailability(int hotelId, LocalDate startDate, LocalDate endDate) {
        List<HotelInfo> hotelRooms = hotelInfoService.getHotelInfoByHotelId(hotelId); 

        List<RoomAvailabilityDTO> roomAvailabilityList = new ArrayList<>();
        
        for (HotelInfo hotelRoom : hotelRooms) {
            String query = "SELECT SUM(NoOfRooms) FROM Booking WHERE InfoId = ? AND BookingStartDate <= ? AND BookingEndDate >= ?";

            @SuppressWarnings("deprecation")
			Integer bookedRooms = jdbcTemplate.queryForObject(query, new Object[] {
                    hotelRoom.getInfoid(), endDate, startDate
            }, Integer.class);
            int availableRooms = hotelRoom.getNoofrooms() - Optional.ofNullable(bookedRooms).orElse(0);
            roomAvailabilityList.add(new RoomAvailabilityDTO(hotelRoom.getRoomtype(), availableRooms));
        }
        
        return roomAvailabilityList;
    }


    
    public List<BookingDTO> showBooking() {
        List<Booking> bookings = bookingRepo.findAll();
        List<BookingDTO> bookingDTOs = new ArrayList<>();
        
        for (Booking booking : bookings) {
            BookingDTO dto = new BookingDTO();
            dto.setBookingid(booking.getBookingid());
//            dto.setCustomerid(booking.getCustomer().getCustomerid());
//            dto.setHotelid(booking.getHotelinfo().getInfoid());
            dto.setBookingstartdate(booking.getBookingstartdate());
            dto.setBookingenddate(booking.getBookingenddate());
            dto.setAdvanceamount(booking.getAdvanceamount());
            dto.setBookingdate(booking.getBookingdate());
            dto.setComments(booking.getComments());
            dto.setRoomtype(booking.getRoomtype());
            dto.setBedtype(booking.getBedtype());
            dto.setNoofrooms(booking.getNoofrooms());
            dto.setNoofadults(booking.getNoofadults());
            dto.setNoofchildren(booking.getNoofchildren());
            dto.setStatus(booking.getStatus());
            
            bookingDTOs.add(dto);
        }
        return bookingDTOs;
    }
    
    
    
    public String addBooking(Booking booking) throws Exception {
        // Fetch the hotel information by infoid
        HotelInfo hotelInfo = hotelInfoRepo.findByInfoid(booking.getHotelinfo().getInfoid());

        if (hotelInfo == null) {
            throw new Exception("Hotel info not found with infoid: " + booking.getHotelinfo().getInfoid());
        }

     // Check if the room type and bed type match (case-insensitive comparison)
        if (!hotelInfo.getRoomtype().equalsIgnoreCase(booking.getRoomtype()) ||
            !hotelInfo.getBedtype().equalsIgnoreCase(booking.getBedtype())) {
            return "Booking failed: Room type or bed type does not match!";
        }
        
        // Check if the requested number of rooms is less than available rooms
        if (booking.getNoofrooms() > hotelInfo.getAvailablerooms()) {
            throw new Exception("Requested rooms are not available");
        }

        // Deduct the booked rooms from available rooms
        hotelInfo.setAvailablerooms(hotelInfo.getAvailablerooms() - booking.getNoofrooms());
        hotelInfoRepo.save(hotelInfo); // Save updated hotel info

        // Save the booking
        booking.setBookingdate(LocalDate.now());
        booking.setStatus("BOOKED");
        Booking savedBooking = bookingRepo.save(booking);

     // Calculate the number of days of the booking
        long noOfDays = java.time.temporal.ChronoUnit.DAYS.between(booking.getBookingstartdate(), booking.getBookingenddate());
        
        
        // Calculate bill amount based on hotelInfo rent and update payment
        double billAmount = hotelInfo.getRent() * booking.getNoofrooms()* noOfDays;
        double advanceAmount = booking.getAdvanceamount();
        double balanceAmount = billAmount - advanceAmount;

        Payment payment = new Payment(savedBooking, billAmount, advanceAmount, 
                                      (int) noOfDays, balanceAmount, LocalDate.now(), "Initial Payment");
        paymentRepo.save(payment); // Save payment details

        return "Booked Successfully";
    }
        
    
 
    
    
    public String cancelBooking(int bookingId) {
        // Fetch the booking by ID
        Optional<Booking> bookingOptional = bookingRepo.findById(bookingId);
        if (!bookingOptional.isPresent()) {
            return "Booking not found";
        }

        Booking booking = bookingOptional.get();

        // Check if the booking is already cancelled
        if ("CANCELLED".equalsIgnoreCase(booking.getStatus())) {
            return "Booking is already cancelled.";
        }

        // Fetch the payment details for the booking
        Payment payment = paymentRepo.findByBooking_Bookingid(bookingId);
        if (payment == null) {
            return "Payment details not found for the booking.";
        }

        // Deduct 10% from the advance amount
        double deductionAmount = payment.getAdvanceAmount() * 0.10;
        double refundAmount = payment.getAdvanceAmount() - deductionAmount;

        // Update the booking status to CANCELLED
        booking.setStatus("CANCELLED");
        bookingRepo.save(booking);
        
        
     // Fetch the corresponding HotelInfo record for the booking
        HotelInfo hotelInfo = booking.getHotelinfo();
        if (hotelInfo == null) {
            return "Hotel information not found for the booking.";
        }

        // Add the cancelled number of rooms back to the available rooms
        int cancelledRooms = booking.getNoofrooms();
        hotelInfo.setAvailablerooms(hotelInfo.getAvailablerooms() + cancelledRooms);
        hotelInfoRepo.save(hotelInfo); // Save the updated hotel info to the database

        

        // Create a refund record
        Refund refund = new Refund();
        refund.setBooking(booking);
        refund.setCustomer(booking.getCustomer());
        refund.setRefundAmount((int) refundAmount);
        refund.setCancelDate(LocalDate.now());
        refund.setRefundDate(LocalDate.now());
        refundRepo.save(refund);

        return "Booking cancelled and refund processed.";
    }

    
}
