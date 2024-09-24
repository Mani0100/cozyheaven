package com.hexaware.ccozyhaven;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.hexaware.cozyhaven.model.Hotel;

public class HotelTest {

    @Test
    public void testGettersAndSetters() {
        Hotel hotel = new Hotel();
        
        // Set values using setters
        hotel.setHotelid(1);
        hotel.setHotelname("The Taj Mahal Palace");
        hotel.setHoteltype("Luxury");
        hotel.setCity("Mumbai");
        hotel.setState("Maharashtra");
        hotel.setEmail("taj.mumbai@gmail.com");
        hotel.setContactnumber(9166665656L);
        hotel.setFacilities("Spa, Pool, Gym, Free Wi-Fi");
        hotel.setCapacity(300);
        hotel.setAddress("Apollo Bunder, Colaba");
        
        // Assert that getters return the correct values
        assertEquals(1, hotel.getHotelid());
        assertEquals("The Taj Mahal Palace", hotel.getHotelname());
        assertEquals("Luxury", hotel.getHoteltype());
        assertEquals("Mumbai", hotel.getCity());
        assertEquals("Maharashtra", hotel.getState());
        assertEquals("taj.mumbai@gmail.com", hotel.getEmail());
        assertEquals(9166665656L, hotel.getContactnumber());
        assertEquals("Spa, Pool, Gym, Free Wi-Fi", hotel.getFacilities());
        assertEquals(300, hotel.getCapacity());
        assertEquals("Apollo Bunder, Colaba", hotel.getAddress());
    }
    
    @Test
    public void testParameterizedConstructor() {
        Hotel hotel = new Hotel(1, "The Taj Mahal Palace", "Luxury", "Mumbai", "Maharashtra", "taj.mumbai@gmail.com", 
        		9166665656L, "Spa, Pool, Gym, Free Wi-Fi", 300, "Apollo Bunder, Colaba");
        
        assertEquals(1, hotel.getHotelid());
        assertEquals("The Taj Mahal Palace", hotel.getHotelname());
        assertEquals("Luxury", hotel.getHoteltype());
        assertEquals("Mumbai", hotel.getCity());
        assertEquals("Maharashtra", hotel.getState());
        assertEquals("taj.mumbai@gmail.com", hotel.getEmail());
        assertEquals(9166665656L, hotel.getContactnumber());
        assertEquals("Spa, Pool, Gym, Free Wi-Fi", hotel.getFacilities());
        assertEquals(300, hotel.getCapacity());
        assertEquals("Apollo Bunder, Colaba", hotel.getAddress());
    }
}
