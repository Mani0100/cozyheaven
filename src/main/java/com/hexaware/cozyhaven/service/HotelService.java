package com.hexaware.cozyhaven.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.hexaware.cozyhaven.model.Hotel;
import com.hexaware.cozyhaven.repository.HotelRepository;

@Service
public class HotelService {

	@Autowired
    private HotelRepository hotelRepo;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public List<Hotel> showAllHotels() {
        return hotelRepo.findAll();
    }

    public void addHotel(Hotel hotel) {
        hotelRepo.save(hotel);
    }
    
    @SuppressWarnings("deprecation")
	public List<Hotel> searchByCity(String city) {
        String cmd = "SELECT * FROM hotel WHERE City = ?";
        return jdbcTemplate.query(cmd, new Object[]{city}, new RowMapper<Hotel>() {

            @Override
            public Hotel mapRow(ResultSet rs, int rowNum) throws SQLException {
                Hotel hotel = new Hotel();
                hotel.setHotelid(rs.getInt("HotelId"));
                hotel.setHotelname(rs.getString("HotelName"));
                hotel.setHoteltype(rs.getString("HotelType"));
                hotel.setCity(rs.getString("City"));
                hotel.setState(rs.getString("State"));
                hotel.setEmail(rs.getString("Email"));
                hotel.setContactnumber(rs.getLong("ContactNumber"));
                hotel.setFacilities(rs.getString("Facilities"));
                hotel.setCapacity(rs.getInt("Capacity"));
                hotel.setAddress(rs.getString("Address"));
                return hotel;
            }
        });
    }
    
    @SuppressWarnings("deprecation")
	public List<Hotel> searchByHotelType(String hotelType) {
        String cmd = "SELECT * FROM hotel WHERE HotelType = ?";
        return jdbcTemplate.query(cmd, new Object[]{hotelType}, new RowMapper<Hotel>() {

            @Override
            public Hotel mapRow(ResultSet rs, int rowNum) throws SQLException {
                Hotel hotel = new Hotel();
                hotel.setHotelid(rs.getInt("HotelId"));
                hotel.setHotelname(rs.getString("HotelName"));
                hotel.setHoteltype(rs.getString("HotelType"));
                hotel.setCity(rs.getString("City"));
                hotel.setState(rs.getString("State"));
                hotel.setEmail(rs.getString("Email"));
                hotel.setContactnumber(rs.getLong("ContactNumber"));
                hotel.setFacilities(rs.getString("Facilities"));
                hotel.setCapacity(rs.getInt("Capacity"));
                hotel.setAddress(rs.getString("Address"));
                return hotel;
            }
        });
    }
    
	
}
