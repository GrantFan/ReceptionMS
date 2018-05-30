package com.reception.hotel.api;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.reception.hotel.model.Hotel_graph;

public interface Hotel_graphService {
	
	/*
	 * Describe 新增酒店图片信息
	 * @param hotel
	 * return int
	 * */
	public int addHotel_graph(Hotel_graph hotel_graph);
	
	
	/*
	 * Describe 删除酒店图片信息
	 * @param id
	 * return int
	 * */
	public int deleteHotel_graph(String id);

	/*
	 * Describe 删除酒店图片信息
	 * @param id
	 * return int
	 * */
	public int deleteHotel_graphByHotel(String hotel);
	
	/*
	 * Describe 修改酒店图片信息
	 * @param id
	 * return int
	 * */
	public int updateHotel_graphByHotel(Hotel_graph graph);
	
	/*
	 * Describe 查询酒店图片信息
	 * @param id
	 * return int
	 * */
	public List<Hotel_graph> selectHotel_graphByHotel(String hotel);
	
	/*
	 * Describe 查询酒店图片信息
	 * return int
	 * */
	public List<String> selectGraph_url();

	/*
	 * Describe 查询酒店图片信息
	 * @param id
	 * return int
	 * */
	public List<Hotel_graph> selectHotel_graphByFloor(Hotel_graph hotel_graph);
}
