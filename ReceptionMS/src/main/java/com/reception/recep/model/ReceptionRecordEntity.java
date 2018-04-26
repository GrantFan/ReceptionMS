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
	private String receptionPrinter;//接待资料打印人员
	private String description;//描述
	private String recordTime;//登记时间
	private String remark;//备注
	
	private String guestName;//宾客姓名
	private String entourage;//陪同人员
	private Integer guestNum;//来宾人数
	private Integer receptionNum;//接待人次
	private String receptionDays;//接待天数
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
	public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	public String getReceptionPrinter() {
		return receptionPrinter;
	}
	public void setReceptionPrinter(String receptionPrinter) {
		this.receptionPrinter = receptionPrinter;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getEntourage() {
		return entourage;
	}
	public void setEntourage(String entourage) {
		this.entourage = entourage;
	}
	public Integer getGuestNum() {
		return guestNum;
	}
	public void setGuestNum(Integer guestNum) {
		this.guestNum = guestNum;
	}
	public Integer getReceptionNum() {
		return receptionNum;
	}
	public void setReceptionNum(Integer receptionNum) {
		this.receptionNum = receptionNum;
	}
	public String getReceptionDays() {
		return receptionDays;
	}
	public void setReceptionDays(String receptionDays) {
		this.receptionDays = receptionDays;
	}
	
}
