package com.hexaware.ccozyhaven;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.hexaware.cozyhaven.model.Hotel;
import com.hexaware.cozyhaven.repository.HotelRepository;
import com.hexaware.cozyhaven.service.HotelService;

public class HotelServiceTest {

    @Mock
    private HotelRepository hotelRepo;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private HotelService hotelService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testShowAllHotels() {
        // Arrange
        List<Hotel> mockHotels = Arrays.asList(
                new Hotel(),
                new Hotel()
        );
        when(hotelRepo.findAll()).thenReturn(mockHotels);

        // Act
        List<Hotel> result = hotelService.showAllHotels();

        // Assert
        assertEquals(2, result.size());
        verify(hotelRepo, times(1)).findAll();
    }

    @Test
    public void testAddHotel() {
        // Arrange
        Hotel mockHotel = new Hotel();

        // Act
        hotelService.addHotel(mockHotel);

        // Assert
        verify(hotelRepo, times(1)).save(mockHotel);
    }

    @Test
    public void testSearchByCity() {
        // Arrange
        String city = "Hyderabad";
        List<Hotel> mockHotels = Arrays.asList(new Hotel());
        String cmd = "SELECT * FROM hotel WHERE City = ?";

        when(jdbcTemplate.query(eq(cmd), any(Object[].class), any(RowMapper.class)))
            .thenReturn(mockHotels);

        // Act
        List<Hotel> result = hotelService.searchByCity(city);

        // Assert
        assertEquals(1, result.size());
        verify(jdbcTemplate, times(1)).query(eq(cmd), any(Object[].class), any(RowMapper.class));
    }

    @Test
    public void testSearchByHotelType() {
        // Arrange
        String hotelType = "Luxury";
        List<Hotel> mockHotels = Arrays.asList(new Hotel());
        String cmd = "SELECT * FROM hotel WHERE HotelType = ?";

        when(jdbcTemplate.query(eq(cmd), any(Object[].class), any(RowMapper.class)))
            .thenReturn(mockHotels);

        // Act
        List<Hotel> result = hotelService.searchByHotelType(hotelType);

        // Assert
        assertEquals(1, result.size());
        verify(jdbcTemplate, times(1)).query(eq(cmd), any(Object[].class), any(RowMapper.class));
    }

    // Helper method to simulate row mapping (Optional)
    private Hotel mockResultSetToHotel(ResultSet rs) throws SQLException {
        Hotel hotel = new Hotel();
        when(rs.getInt("HotelId")).thenReturn(1);
        when(rs.getString("HotelName")).thenReturn("The Taj Mahal Palace");
        when(rs.getString("HotelType")).thenReturn("Luxury");
        when(rs.getString("City")).thenReturn("Mumbai");
        when(rs.getString("State")).thenReturn("Maharashtra");
        when(rs.getString("Email")).thenReturn("taj.mumbai@gmail.com");
        when(rs.getLong("ContactNumber")).thenReturn(9166665656L);
        when(rs.getString("Facilities")).thenReturn("Spa, Pool, Gym, Free Wi-Fi");
        when(rs.getInt("Capacity")).thenReturn(300);
        when(rs.getString("Address")).thenReturn("Apollo Bunder, Colaba");
        return hotel;
    }
}
