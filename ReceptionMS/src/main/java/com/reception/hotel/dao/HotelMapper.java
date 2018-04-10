package com.reception.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.reception.hotel.model.HotelInfoEntity;

@Mapper
public interface HotelMapper {

	@Insert(value = { "" })
	public int addHotelInfo(HotelInfoEntity hotel);
	
	@Update(value = { "" })
	public int updateHotelInfo(HotelInfoEntity hotel);
	
	@Delete(value = { "" })
	public int deleteHotelInfo(HotelInfoEntity hotel);
	
	@Select(value = { "" })
	public List<HotelInfoEntity> selectList();
}
