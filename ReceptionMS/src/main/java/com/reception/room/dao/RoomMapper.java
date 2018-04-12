package com.reception.room.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.reception.room.model.RoomInfoEntity;

@Mapper
public interface RoomMapper {

	@Insert("insert into room_info(room_number,hotel,floor,room_type,special_type,orientation,support_facilities,special_serve,outside_phone,innerline_phone,responsible_person,rack_price,agreement_price,contain_food,state,remark) "
			+ "values(#{roomNumber},#{hotel},#{floor},#{roomType},#{specialType},#{orientation},#{supportFacilities},,#{specialServe},#{outsidePhone},#{innerlinePhone},#{responsiblePerson},#{rackPrice},#{agreementPrice},#{containFood},#{state},#{remark} ")
	public int addRoomInfo(RoomInfoEntity room);
	
	@Update("update room_info set hotel_name=#{hotelName},linkman=#{linkman},telphone=#{telphone},phone=#{phone},area=#{area},address=#{address} ,plane_graph=#{planeGraph},remark=#{remark} where id=#{id}")
	public int updateRoomInfo(RoomInfoEntity room);
	
	@Delete("delete from room_info where id = #{id}")
	public int deleteRoomInfo(RoomInfoEntity room);
	
	@Select("select id,room_number,hotel,floor,room_type,special_type,orientation,support_facilities,special_serve,outside_phone,innerline_phone,responsible_person,rack_price,agreement_price,contain_food,state,remark from  room_info order by room_number")
	public List<RoomInfoEntity> selectList();
	
	@Select({"<script>",	
		"select id,room_number,hotel,floor,room_type,special_type,orientation,support_facilities,special_serve,outside_phone,innerline_phone,responsible_person,rack_price,agreement_price,contain_food,state,remark from  room_info where 1=1 ",
		"<when test='hotel!=null'>",
		"and hotel = #{hotel}",
		"</when>",
		"</script>"})
	public List<RoomInfoEntity> selectListByHotel(RoomInfoEntity room);
}
