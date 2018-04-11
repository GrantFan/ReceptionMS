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

	@Insert("insert into room_info(roomNumber,floor,orientation,outsidePhone,area,address,plane_graph,remark) values(#{hotelName},#{linkman},#{telphone},#{phone},#{area},#{address},#{planeGraph},#{remark} ")
	public int addRoomInfo(RoomInfoEntity room);
	
	@Update("update room_info set hotel_name=#{hotelName},linkman=#{linkman},telphone=#{telphone},phone=#{phone},area=#{area},address=#{address} ,plane_graph=#{planeGraph},remark=#{remark} where id=#{id}")
	public int updateRoomInfo(RoomInfoEntity room);
	
	@Delete("delete from room_info where id = #{id}")
	public int deleteRoomInfo(RoomInfoEntity room);
	
	@Select("select id,hotel_name,linkman,telphone,phone,area,address,plane_graph,remark from  room_info order by id")
	public List<RoomInfoEntity> selectList();
}
