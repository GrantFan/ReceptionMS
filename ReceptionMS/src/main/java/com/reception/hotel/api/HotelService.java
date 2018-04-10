package com.reception.hotel.api;

import java.util.List;


import com.reception.hotel.model.HotelInfoEntity;

public interface HotelService {

	public int addHotelInfo(HotelInfoEntity hotel);
	
	public int updateHotelInfo(HotelInfoEntity hotel);
	
	public int deleteHotelInfo(HotelInfoEntity hotel);
	
	public List<HotelInfoEntity> selectList();
}
