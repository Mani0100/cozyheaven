package com.hexaware.cozyhaven.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.cozyhaven.model.HotelInfo;
@Repository
public interface HotelInfoRepository extends JpaRepository<HotelInfo, Integer> {

	 List<HotelInfo> findByHotel_hotelid(int hotelid);
	 HotelInfo findByInfoid(int infoid);
}
