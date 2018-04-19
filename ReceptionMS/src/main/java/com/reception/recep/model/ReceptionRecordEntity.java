package com.reception.recep.model;

/*
 * 接待记录实体
 */
public class ReceptionRecordEntity {
	
	private Integer id;
	private String receptionNumber ;//接待编号
	private String receptionTitle;//接待名称
	private String receptionDate;//接待日期
	private String receptionPerson;//接待人
	private String description;//描述
	private String recordTime;//登记时间
	private String remark;//备注
	
	private String guest;//宾客
	private String hotel;//酒店
	
	
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
	public String getReceptionTitle() {
		return receptionTitle;
	}
	public void setReceptionTitle(String receptionTitle) {
		this.receptionTitle = receptionTitle;
	}
	public String getReceptionDate() {
		return receptionDate;
	}
	public void setReceptionDate(String receptionDate) {
		this.receptionDate = receptionDate;
	}
	public String getReceptionPerson() {
		return receptionPerson;
	}
	public void setReceptionPerson(String receptionPerson) {
		this.receptionPerson = receptionPerson;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getGuest() {
		return guest;
	}
	public void setGuest(String guest) {
		this.guest = guest;
	}
	public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
}
