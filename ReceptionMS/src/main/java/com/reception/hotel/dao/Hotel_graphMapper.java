package com.reception.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.reception.hotel.model.Hotel_graph;

@Mapper
public interface Hotel_graphMapper {

	/*
	 * Describe 新增酒店图片信息
	 * @param hotel
	 * return int
	 * */
	@Insert("insert into hotel_plane_graph(id,graph_name,graph_url,floor,hotel) values((select nvl(MAX(id),0)+1 from hotel_plane_graph),#{graph_name},#{graph_url},#{floor},#{hotel})")
	public int addHotel_graph(Hotel_graph hotel_graph);
	
	
	/*
	 * Describe 删除酒店图片信息
	 * @param id
	 * return int
	 * */
	@Delete("delete from hotel_plane_graph where id = #{id}")
	public int deleteHotel_graph(String id);
	
	/*
	 * Describe 删除酒店图片信息
	 * @param id
	 * return int
	 * */
	@Delete("delete from hotel_plane_graph where hotel = #{hotel}")
	public int deleteHotel_graphByHotel(String hotel);
	
	/*
	 * Describe 查询酒店图片信息
	 * @param id
	 * return int
	 * */
    @Select("select * from hotel_plane_graph where hotel = #{hotel}")
	public List<Hotel_graph> selectHotel_graphByHotel(String hotel);
	
	/*
	 * Describe 查询酒店图片信息
	 * @param id
	 * return int
	 * */
    @Select("select * from hotel_plane_graph where hotel = #{hotel} and floor=#{floor}")
	public List<Hotel_graph> selectHotel_graphByFloor(Hotel_graph graph);
	
	/*
	 * Describe 查询酒店图片信息
	 * return int
	 * */
    @Select("select graph_url from hotel_plane_graph")
	public List<String> selectGraph_url();

	/*
	 * Describe 修改酒店图片信息
	 * return int
	 * */
    @Update("update hotel_plane_graph set floor=#{floor},graph_name=#{graph_name} where id=#{id}")
	public int updateHotel_graphByHotel(Hotel_graph graph);
	
}
