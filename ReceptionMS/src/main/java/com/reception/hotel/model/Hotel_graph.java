package com.reception.hotel.model;

import java.io.Serializable;

public class Hotel_graph implements Serializable{
	
	/**
	 * id
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 图片名称
	 */
	private String graph_name = "";
	/**
	 * 图片路径
	 */
	private String graph_url = "";
	/**
	 * 楼层
	 */
	private String floor = "";
	/**
	 * 酒店
	 */
	private String hotel = "";
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGraph_name() {
		return graph_name;
	}
	public void setGraph_name(String graph_name) {
		this.graph_name = graph_name;
	}
	public String getGraph_url() {
		return graph_url;
	}
	public void setGraph_url(String graph_url) {
		this.graph_url = graph_url;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	@Override
	public String toString() {
		return "Hotel_graph [id=" + id + ", graph_name=" + graph_name + ", graph_url=" + graph_url + ", floor=" + floor
				+ ", hotel=" + hotel + "]";
	}
	
}
