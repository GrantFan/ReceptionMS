package com.reception.recep.model;

/*
 * 接待用餐记录实体
 */
public class MealsRecordEntity {
	
	private Integer id;
	private String receptionNumber;//接待编号
	private String hotel;//酒店
	private String menuNumber;//套餐编号
	private String mealsTime;//用餐时间
	private String hobby;//客人用餐喜好
	private String recordTime;//登记时间
	private String remark;//备用字段
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getReceptionNumber() {
		return receptionNumber;
	}
	public void setReceptionNumber(String receptionNumber) {
		this.receptionNumber = receptionNumber;
	}
	public String getMenuNumber() {
		return menuNumber;
	}
	public void setMenuNumber(String menuNumber) {
		this.menuNumber = menuNumber;
	}
	public String getMealsTime() {
		return mealsTime;
	}
	public void setMealsTime(String mealsTime) {
		this.mealsTime = mealsTime;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	public String getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}
	
}
