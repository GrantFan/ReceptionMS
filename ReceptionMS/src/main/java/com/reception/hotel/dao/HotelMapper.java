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

	@Insert("insert into hotel_info(hotel_name,linkman,telphone,phone,area,address,plane_graph,remark) values(#{hotelName},#{linkman},#{telphone},#{phone},#{area},#{address},#{planeGraph},#{remark} ")
	public int addHotelInfo(HotelInfoEntity hotel);
	
	@Update("update hotel_info set hotel_name=#{hotelName},linkman=#{linkman},telphone=#{telphone},phone=#{phone},area=#{area},address=#{address} ,plane_graph=#{planeGraph},remark=#{remark} where id=#{id}")
	public int updateHotelInfo(HotelInfoEntity hotel);
	
	@Delete("delete from hotel_info where id = #{id}")
	public int deleteHotelInfo(HotelInfoEntity hotel);
	
	@Select("select id,hotel_name,linkman,telphone,phone,area,address,plane_graph,remark from  hotel_info order by hotel_name")
	public List<HotelInfoEntity> selectList();
}
