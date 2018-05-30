package com.reception.hotel.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.reception.hotel.api.Hotel_graphService;
import com.reception.hotel.dao.Hotel_graphMapper;
import com.reception.hotel.model.Hotel_graph;

@Service
public class Hotel_graphServiceImpl implements Hotel_graphService{
	
	@Resource
	private Hotel_graphMapper hotel_graphmapper;

	 /* Describe 新增酒店图片信息
	 * @param hotel
	 * return int
	 * */
	public int addHotel_graph(Hotel_graph hotel_graph){
		 return hotel_graphmapper.addHotel_graph(hotel_graph);
	 }
	
	
	/*
	 * Describe 删除酒店图片信息
	 * @param id
	 * return int
	 * */
	public int deleteHotel_graph(String id){
		 return hotel_graphmapper.deleteHotel_graph(id);
	}


	/**
	 * 根据酒店信息，删除图片
	 */
	@Override
	public int deleteHotel_graphByHotel(String hotel) {
		return hotel_graphmapper.deleteHotel_graphByHotel(hotel);
	}
	
	/*
	 * Describe 查询酒店图片信息
	 * @param id
	 * return int
	 * */
	public List<Hotel_graph> selectHotel_graphByHotel(String hotel){
		return hotel_graphmapper.selectHotel_graphByHotel(hotel);
	}
	
	/*
	 * Describe 查询酒店图片信息
	 * @param id
	 * return int
	 * */
	public List<Hotel_graph> selectHotel_graphByFloor(Hotel_graph graph){
		return hotel_graphmapper.selectHotel_graphByFloor(graph);
	}
	
	/*
	 * Describe 查询酒店图片信息
	 * return int
	 * */
	public List<String> selectGraph_url(){
		return hotel_graphmapper.selectGraph_url();
	}


	@Override
	public int updateHotel_graphByHotel(Hotel_graph graph) {
		// TODO Auto-generated method stub
		return hotel_graphmapper.updateHotel_graphByHotel(graph);
	}

}
