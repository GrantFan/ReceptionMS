package com.reception.restaurant.model;

import com.reception.util.poi.ModelProp;
import com.reception.util.poi.ModelTitle;

/*
 * 餐厅包厢信息实体
 */
@ModelTitle(name = "餐厅包厢信息")
public class RestaurantInfoEntity {
	private String id;
	/**餐厅编号
	 * 
	 */
	@ModelProp(name = "餐厅编号",colIndex = 1)
	private String restaurant_number;
	/**餐厅名 包厢名
	 * 
	 */
	@ModelProp(name = "餐厅名 包厢名",colIndex = 2)
	private String restaurant_name;
	/**餐厅类型
	 * 
	 */
	@ModelProp(name = "餐厅类型",colIndex = 3)
	private String restaurant_type;
	/**所属酒店
	 * 
	 */
	@ModelProp(name = "所属酒店",colIndex = 4)
	private String hotel;
	/**位置 在哪座楼
	 * 
	 */
	@ModelProp(name = "位置 在哪座楼",colIndex = 5)
	private String position;
	/**楼层
	 * 
	 */
	@ModelProp(name = "楼层",colIndex = 6)
	private String floor;
	/* 容纳人数
	 * 
	 */
	@ModelProp(name = "餐厅编号",colIndex = 7)
	private String capacity_num;
	/**状态
	 * 
	 */
	@ModelProp(name = "状态",colIndex = 8)
	private String state;
	/**备注
	 * 
	 */
	@ModelProp(name = "备注",colIndex = 9)
	private String remark;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRestaurant_number() {
		return restaurant_number;
	}
	public void setRestaurant_number(String restaurant_number) {
		this.restaurant_number = restaurant_number;
	}
	public String getRestaurant_name() {
		return restaurant_name;
	}
	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}
	public String getRestaurant_type() {
		return restaurant_type;
	}
	public void setRestaurant_type(String restaurant_type) {
		this.restaurant_type = restaurant_type;
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
	public String getCapacity_num() {
		return capacity_num;
	}
	public void setCapacity_num(String capacity_num) {
		this.capacity_num = capacity_num;
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
