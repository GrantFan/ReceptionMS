package com.reception.hotel.api;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.reception.hotel.model.HotelInfoEntity;

public interface HotelService {

	public int addHotelInfo(HotelInfoEntity hotel);
	
	public int updateHotelInfo(HotelInfoEntity hotel);
	
	public int deleteHotelInfo(HotelInfoEntity hotel);
	
	/*
	 * Describe 查询酒店列表
	 * @param 
	 * return list
	 * */
	public List<HotelInfoEntity> selectList();
	
	/*
	 * Describe 通过酒店名称查询酒店列表
	 * @param hotelName
	 * return list
	 * */
	public List<HotelInfoEntity> selectListByName(HotelInfoEntity hotel);
}
