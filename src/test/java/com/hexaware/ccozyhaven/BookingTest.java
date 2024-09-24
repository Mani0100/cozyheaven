package com.hexaware.ccozyhaven;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.hexaware.cozyhaven.model.Booking;
import com.hexaware.cozyhaven.model.Customer;
import com.hexaware.cozyhaven.model.HotelInfo;

public class BookingTest {

    @Test
    public void testGettersAndSetters() {
        // Create instances for Customer and HotelInfo as they are used in Booking
        Customer customer = new Customer();
        HotelInfo hotelInfo = new HotelInfo();

        // Initialize the Booking object using the default constructor
        Booking booking = new Booking();
        
        // Set values using setters
        booking.setBookingid(1);
        booking.setCustomer(customer);
        booking.setHotelinfo(hotelInfo);
        booking.setBookingstartdate(LocalDate.of(2024, 12, 15));
        booking.setBookingenddate(LocalDate.of(2024, 12, 20));
        booking.setAdvanceamount(2000.00);
        booking.setBookingdate(LocalDate.of(2024, 10, 15));
        booking.setComments("Vacation");
        booking.setNoofrooms(1);
        booking.setNoofadults(2);
        booking.setNoofchildren(2);
        booking.setStatus("Booked");
        booking.setRoomtype("AC");
        booking.setBedtype("King");

        // Assert that getters return the correct values
        assertEquals(1, booking.getBookingid());
        assertEquals(customer, booking.getCustomer());
        assertEquals(hotelInfo, booking.getHotelinfo());
        assertEquals(LocalDate.of(2024, 12, 15), booking.getBookingstartdate());
        assertEquals(LocalDate.of(2024, 12, 20), booking.getBookingenddate());
        assertEquals(2000.00, booking.getAdvanceamount());
        assertEquals(LocalDate.of(2024, 10, 15), booking.getBookingdate());
        assertEquals("Vacation", booking.getComments());
        assertEquals(1, booking.getNoofrooms());
        assertEquals(2, booking.getNoofadults());
        assertEquals(2, booking.getNoofchildren());
        assertEquals("Booked", booking.getStatus());
        assertEquals("AC", booking.getRoomtype());
        assertEquals("King", booking.getBedtype());
    }

    @Test
    public void testConstructorWithArguments() {
        // Create instances for Customer and HotelInfo as they are used in Booking
        Customer customer = new Customer();
        HotelInfo hotelInfo = new HotelInfo();
        
        // Create an object using the parameterized constructor
        Booking booking = new Booking(1, customer, hotelInfo, LocalDate.of(2024, 12, 15), 
            LocalDate.of(2024, 12, 20), 2000.00, LocalDate.of(2024, 10, 15), 
            "Vacation", 1, 2, 2, "Booked", "AC", "King");

        // Assert that the fields were set correctly
        assertEquals(1, booking.getBookingid());
        assertEquals(customer, booking.getCustomer());
        assertEquals(hotelInfo, booking.getHotelinfo());
        assertEquals(LocalDate.of(2024, 12, 15), booking.getBookingstartdate());
        assertEquals(LocalDate.of(2024, 12, 20), booking.getBookingenddate());
        assertEquals(2000.00, booking.getAdvanceamount());
        assertEquals(LocalDate.of(2024, 10, 15), booking.getBookingdate());
        assertEquals("Vacation", booking.getComments());
        assertEquals(1, booking.getNoofrooms());
        assertEquals(2, booking.getNoofadults());
        assertEquals(2, booking.getNoofchildren());
        assertEquals("Booked", booking.getStatus());
        assertEquals("AC", booking.getRoomtype());
        assertEquals("King", booking.getBedtype());
    }

    @Test
    public void testDefaultConstructor() {
        // Create an object using the default constructor
        Booking booking = new Booking();

        // Assert that the object was created and is not null
        assertNotNull(booking);
    }
}
