package com.reception.restaurant.model;

/*
 * 餐厅包厢信息实体
 */
public class RestaurantInfoEntity {
	private Integer id;
	private String restaurantNumber;
	private String restaurantName;
	private String restaurantType;
	private String hotel;
	private String position;
	private String floor;
	private String capacityNum;
	private String state;
	private String remark;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRestaurantNumber() {
		return restaurantNumber;
	}
	public void setRestaurantNumber(String restaurantNumber) {
		this.restaurantNumber = restaurantNumber;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRestaurantType() {
		return restaurantType;
	}
	public void setRestaurantType(String restaurantType) {
		this.restaurantType = restaurantType;
	}
	public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getCapacityNum() {
		return capacityNum;
	}
	public void setCapacityNum(String capacityNum) {
		this.capacityNum = capacityNum;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
