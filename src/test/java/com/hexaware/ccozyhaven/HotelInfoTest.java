package com.hexaware.ccozyhaven;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.hexaware.cozyhaven.model.Hotel;
import com.hexaware.cozyhaven.model.HotelInfo;

public class HotelInfoTest {

    @Test
    public void testGettersAndSetters() {
        // Create a new HotelInfo object using the default constructor
        HotelInfo hotelInfo = new HotelInfo();

        // Create a dummy Hotel object
        Hotel hotel = new Hotel();
        hotel.setHotelid(1);
        hotel.setHotelname("The Taj Mahal Palace");

        // Set values using setters
        hotelInfo.setInfoid(1);
        hotelInfo.setHotel(hotel);
        hotelInfo.setRoomtype("AC");
        hotelInfo.setNoofrooms(10);
        hotelInfo.setAvailablerooms(10);
        hotelInfo.setRent(8000.00);
        hotelInfo.setRoomsize("Medium");
        hotelInfo.setBedtype("King");

        // Assert that the getters return the correct values
        assertEquals(1, hotelInfo.getInfoid());
        assertEquals(hotel, hotelInfo.getHotel());
        assertEquals("AC", hotelInfo.getRoomtype());
        assertEquals(10, hotelInfo.getNoofrooms());
        assertEquals(10, hotelInfo.getAvailablerooms());
        assertEquals(8000.00, hotelInfo.getRent());
        assertEquals("Medium", hotelInfo.getRoomsize());
        assertEquals("King", hotelInfo.getBedtype());
    }

    @Test
    public void testDefaultConstructor() {
        // Create a HotelInfo object using the default constructor
        HotelInfo hotelInfo = new HotelInfo();

        // Assert that the object was created and is not null
        assertNotNull(hotelInfo);
    }

    @Test
    public void testParameterizedConstructor() {
        // Create a dummy Hotel object
        Hotel hotel = new Hotel();
        hotel.setHotelid(1);
        hotel.setHotelname("The Taj Mahal Palace");

        // Create a HotelInfo object using the parameterized constructor
        HotelInfo hotelInfo = new HotelInfo(1, hotel, "AC", 10, 10, 8000.00, "Medium", "King");

        // Assert that the values set in the constructor are correct
        assertEquals(1, hotelInfo.getInfoid());
        assertEquals(hotel, hotelInfo.getHotel());
        assertEquals("AC", hotelInfo.getRoomtype());
        assertEquals(10, hotelInfo.getNoofrooms());
        assertEquals(10, hotelInfo.getAvailablerooms());
        assertEquals(8000.00, hotelInfo.getRent());
        assertEquals("Medium", hotelInfo.getRoomsize());
        assertEquals("King", hotelInfo.getBedtype());
    }
}
