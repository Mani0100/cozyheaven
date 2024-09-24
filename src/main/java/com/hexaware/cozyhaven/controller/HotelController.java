package com.hexaware.cozyhaven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cozyhaven.model.Hotel;
import com.hexaware.cozyhaven.service.HotelService;

@RestController
@RequestMapping(value="/hotel")
public class HotelController {

	 @Autowired
	    private HotelService hotelService;
	 
	 @PostMapping(value = "/addHotel")
	    public void addHotel(@RequestBody Hotel hotel) {
	        hotelService.addHotel(hotel);
	    }
	 
	 @GetMapping(value = "/showHotels")
	    public List<Hotel> showAllHotels() {
	        return hotelService.showAllHotels();
	    }
	 
	 @GetMapping(value = "/searchByCity/{city}")
	    public List<Hotel> searchByCity(@PathVariable String city) {
	        return hotelService.searchByCity(city);
	    }
	 
	 @GetMapping(value = "/searchByType/{hotelType}")
	    public List<Hotel> searchByHotelType(@PathVariable String hotelType) {
	        return hotelService.searchByHotelType(hotelType);
	    }
	 
}
