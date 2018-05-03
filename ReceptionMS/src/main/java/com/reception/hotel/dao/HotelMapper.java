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

	/*
	 * Describe 新增酒店信息
	 * @param hotel
	 * return int
	 * */
	@Insert("insert into hotel_info(hotel_name,linkman,telphone,phone,area,address,plane_graph,remark) values(#{hotelName},#{linkman},#{telphone},#{phone},#{area},#{address},#{planeGraph},#{remark} )")
	public int addHotelInfo(HotelInfoEntity hotel);
	
	/*
	 * Describe 修改酒店信息
	 * @param hotel
	 * return int
	 * */
	@Update("update hotel_info set hotel_name=#{hotelName},linkman=#{linkman},telphone=#{telphone},phone=#{phone},area=#{area},address=#{address} ,plane_graph=#{planeGraph},remark=#{remark} where id=#{id}")
	public int updateHotelInfo(HotelInfoEntity hotel);
	
	/*
	 * Describe 删除酒店信息
	 * @param id
	 * return int
	 * */
	@Delete("delete from hotel_info where id = #{id}")
	public int deleteHotelInfo(HotelInfoEntity hotel);
	
	/*
	 * Describe 查询酒店列表
	 * @param 分页
	 * return list
	 * */
	@Select("select id,hotel_name hotelName,linkman,telphone,phone,area,address,plane_graph planeGraph,remark from  hotel_info order by hotel_name")
	public List<HotelInfoEntity> selectList();
	
	/*
	 * Describe 通过酒店名称查询酒店列表
	 * @param hotelName
	 * return list
	 * */
	@Select({"<script>",
			"select id,hotel_name hotelName,linkman,telphone,phone,area,address,plane_graph planeGraph,remark from  hotel_info where 1=1 ",
			"<if test=\" '' != hotelName  and null != hotelName\">",
			"and hotel_name like concat(#{hotelName},'%') ",
			"</if>",
			"order by hotel_name",
			"</script>"})
	public List<HotelInfoEntity> selectListByName(HotelInfoEntity hotel);

	/*
	 * Describe 通过酒店名称查询酒店列表
	 * @param hotelName
	 * return list
	 * */
	@Select({"<script>",
			"select id,hotel_name hotelName,linkman,telphone,phone,area,address,plane_graph planeGraph,remark from  hotel_info where id = #{id} ",
			"</script>" })
	public HotelInfoEntity selectById(String id);
}
