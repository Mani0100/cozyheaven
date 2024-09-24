package com.hexaware.cozyhaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hexaware.cozyhaven.dto.BookingDTO;
import com.hexaware.cozyhaven.dto.RoomAvailabilityDTO;
import com.hexaware.cozyhaven.model.Booking;
import com.hexaware.cozyhaven.service.BookingService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value="/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping(value="/showBooking")
    public List<BookingDTO> showBooking() {
        return bookingService.showBooking();
    }
    
    
    @PostMapping(value = "/addBooking")
    public ResponseEntity<String> addBooking(@RequestBody Booking booking) {
    	 try {
             bookingService.addBooking(booking);
             return ResponseEntity.ok("Booked Successfully");
         } catch (Exception e) {
             return ResponseEntity.badRequest().body("Booking Failed: " + e.getMessage());
         }
    }
    

    @GetMapping(value = "/checkAvailability/{hotelId}/{startDate}/{endDate}")
    public List<RoomAvailabilityDTO> checkRoomAvailability(
            @PathVariable int hotelId,
            @PathVariable String startDate,
            @PathVariable String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return bookingService.getRoomAvailability(hotelId, start, end);
    }
    
    
    @PostMapping("/cancelBooking/{bookingId}")
    public ResponseEntity<String> cancelBooking(@PathVariable int bookingId) {
        String result = bookingService.cancelBooking(bookingId);
        return ResponseEntity.ok(result);
    }
    
}
