package com.hexaware.cozyhaven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cozyhaven.model.HotelInfo;
import com.hexaware.cozyhaven.service.HotelInfoService;

@RestController
@RequestMapping(value="/hotelInfo")
public class HotelInfoController {

	@Autowired
    private HotelInfoService hotelInfoService;
	
	@GetMapping(value = "/showHotelInfo")
    public List<HotelInfo> showHotelInfo() {
        return hotelInfoService.showHotelInfo();
    }
}
