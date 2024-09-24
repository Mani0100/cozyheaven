package com.hexaware.cozyhaven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.hexaware.cozyhaven.model.Hotel;
import com.hexaware.cozyhaven.model.HotelInfo;
import com.hexaware.cozyhaven.repository.HotelInfoRepository;

@Service
public class HotelInfoService {

    @Autowired
    private HotelInfoRepository hotelInfoRepo;

 
    public HotelInfo getHotelInfoById(int infoId) {
        return hotelInfoRepo.findById(infoId).orElse(null);
    }

 
    public void saveHotelInfo(HotelInfo hotelInfo) {
        hotelInfoRepo.save(hotelInfo); 
    }

    public List<HotelInfo> getHotelInfoByHotelId(int hotelId) {
        return hotelInfoRepo.findByHotel_hotelid(hotelId);
    }


	public List<HotelInfo> showHotelInfo() {
		return hotelInfoRepo.findAll();
	}
}
