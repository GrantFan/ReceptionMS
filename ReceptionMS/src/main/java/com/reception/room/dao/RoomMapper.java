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

	@Insert("insert into room_info(id,room_number,hotel,floor,room_type,special_type,orientation,support_facilities,special_serve,outside_phone,innerline_phone,responsible_person,rack_price,agreement_price,contain_food,state,remark) "
			+ "values((select nvl(max(id),0)+1 from room_info),#{roomNumber},#{hotel},#{floor},#{roomType},#{specialType},#{orientation},#{supportFacilities},#{specialServe},#{outsidePhone},#{innerlinePhone},#{responsiblePerson},#{rackPrice},#{agreementPrice},#{containFood},#{state},#{remark} )")
	public int addRoomInfo(RoomInfoEntity room);
	
	@Update({"<script>",
			 "update room_info set",
			 " hotel = #{hotel},",
			 " room_number = #{roomNumber},",
			 " floor = #{floor},",
			 " room_type = #{roomType},",
			 " special_type = #{specialType},",
			 " orientation = #{orientation},",
			 " support_facilities = #{supportFacilities},",
			 " special_serve = #{specialServe},",
			 " outside_phone = #{outsidePhone},",
			 " innerline_phone = #{innerlinePhone},",
			 " responsible_person = #{responsiblePerson},",
			 " rack_price = #{rackPrice},",
			 " agreement_price = #{agreementPrice},",
			 " contain_food = #{containFood},",
			 " state = #{state},",
			 " remark = #{remark}",
			 " where id = #{id}",
	"</script>"})
	public int updateRoomInfo(RoomInfoEntity room);
	
	@Delete("delete from room_info where id = #{id}")
	public int deleteRoomInfo(RoomInfoEntity room);
	
	@Select("select id,room_number roomNumber,hotel,floor,room_type roomType,special_type specialType,orientation,support_facilities supportFacilities,special_serve specialServe,outside_phone outsidePhone,innerline_phone innerlinePhone,responsible_person responsiblePerson,rack_price rackPrice,agreement_price agreementPrice,contain_food containFood,state,remark from  room_info order by hotel,floor,room_number")
	public List<RoomInfoEntity> selectList();
	
	@Select({"<script>",
		"select id,room_number roomNumber,hotel,floor,room_type roomType,special_type specialType,orientation,support_facilities supportFacilities,special_serve specialServe,outside_phone outsidePhone,innerline_phone innerlinePhone,responsible_person responsiblePerson,rack_price rackPrice,agreement_price agreementPrice,contain_food containFood,state,remark from  room_info where 1=1 ",
		"<if test=\" '' != hotel  and null != hotel\">",
		" and hotel = #{hotel}",
		"</if>",
		"<if test=\" '' != floor  and null != floor\">",
		" and floor = #{floor}",
		"</if>",
		"ORDER BY floor,orientation,room_number",
		"</script>"})
	public List<RoomInfoEntity> selectListByHotel(RoomInfoEntity room);
	
	@Select({"<script>",
		"select id,room_number roomNumber,hotel,floor,room_type roomType,special_type specialType,orientation,support_facilities supportFacilities,special_serve specialServe,outside_phone outsidePhone,innerline_phone innerlinePhone,responsible_person responsiblePerson,rack_price rackPrice,agreement_price agreementPrice,contain_food containFood,state,remark from  room_info where 1=1 ",
		"<if test=\" '' != hotel  and null != hotel\">",
		" and hotel = #{hotel}",
		"</if>",
		"<if test=\" '' != floor  and null != floor\">",
		" and floor = #{floor}",
		"</if>",
		"<if test=\" '' != orientation  and null != orientation\">",
		" and orientation = #{orientation}",
		"</if>",
		"ORDER BY floor,orientation,room_number",
		"</script>"})
	public List<RoomInfoEntity> selectListByFloor(RoomInfoEntity room);
	
	@Select({"<script>",
		"SELECT orientation,floor,hotel from room_info where 1=1 ",
		"<if test=\" '' != hotel  and null != hotel\">",
		" and hotel = #{hotel}",
		"</if>",
		"<if test=\" '' != floor  and null != floor\">",
		" and floor = #{floor}",
		"</if>",
		" group by orientation,floor,hotel ORDER BY orientation",
		"</script>"})
	public List<RoomInfoEntity> selectFloorByOrientation(RoomInfoEntity room);
	
	@Select({"<script>",
		"SELECT floor,hotel from room_info where 1=1 ",
		"<if test=\" '' != hotel  and null != hotel\">",
		" and hotel = #{hotel}",
		"</if>",
		" group by floor,hotel ORDER BY floor",
		"</script>"})
	public List<RoomInfoEntity> selectFloorByHotel(RoomInfoEntity room);
	
	@Select("select id,room_number roomNumber,hotel,floor,room_type roomType,special_type specialType,orientation,support_facilities supportFacilities,special_serve specialServe,outside_phone outsidePhone,innerline_phone innerlinePhone,responsible_person responsiblePerson,rack_price rackPrice,agreement_price agreementPrice,contain_food containFood,state,remark from  room_info where hotel=#{hotel} and room_type=#{roomType} order by room_number")
	public List<RoomInfoEntity> selectByRoomType(RoomInfoEntity room);

	@Select("select id,room_number roomNumber,hotel,floor,room_type roomType,special_type specialType,orientation,support_facilities supportFacilities,special_serve specialServe,outside_phone outsidePhone,innerline_phone innerlinePhone,responsible_person responsiblePerson,rack_price rackPrice,agreement_price agreementPrice,contain_food containFood,state,remark from  room_info where id=#{id} ")
	public RoomInfoEntity selectById(String id);

	@Select({"<script>",
		"SELECT id,room_number roomNumber,hotel,floor,room_type roomType,special_type specialType,orientation,support_facilities supportFacilities,special_serve specialServe,outside_phone outsidePhone,innerline_phone innerlinePhone,responsible_person responsiblePerson,rack_price rackPrice,agreement_price agreementPrice,contain_food containFood,state,remark from  room_info where 1=1 ",
		"<if test=\" '' != hotel  and null != hotel\">",
		" and hotel = #{hotel}",
		"</if>",
		"<if test=\" '' != roomType  and null != roomType\">",
		" and room_type = #{roomType}",
		"</if>",
		" order by room_number",
		"</script>"})
	public List<RoomInfoEntity> selectListByHotelApp(RoomInfoEntity room);
}
