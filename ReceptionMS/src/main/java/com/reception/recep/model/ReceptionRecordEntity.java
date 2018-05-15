package com.reception.recep.model;

import java.util.List;

import com.reception.util.poi.ModelProp;
import com.reception.util.poi.ModelTitle;

/*
 * 接待记录实体
 */
@ModelTitle(name="接待记录")
public class ReceptionRecordEntity {
	
	@ModelProp(name="ID")
	private Integer id;
	@ModelProp(name="接待编号",colIndex=1)
	private String receptionNumber = "";//接待编号
	@ModelProp(name="接待名称",colIndex=2)
	private String receptionTitle = "";//接待名称
	@ModelProp(name="接待日期",colIndex=3)
	private String receptionDate = "";//接待日期
	@ModelProp(name="接待人员",colIndex=4)
	private String receptionPerson  = "";//接待人员
	@ModelProp(name="接待资料打印人员",colIndex=5)
	private String receptionPrinter  = "";//接待资料打印人员
	@ModelProp(name="宾客姓名",colIndex=6)
	private String guestName = "";//宾客姓名
	@ModelProp(name="陪同人员",colIndex=7)
	private String entourage = "";//陪同人员
	@ModelProp(name="来宾人数",colIndex=8)
	private String guestNum = "";//来宾人数
	@ModelProp(name="接待人次",colIndex=9)
	private String receptionNum = "";//接待人次
	@ModelProp(name="接待天数",colIndex=10)
	private String receptionDays = "";//接待天数
	@ModelProp(name="接待酒店",colIndex=11)
	private String hotel = "";//酒店
	@ModelProp(name="描述",colIndex=12)
	private String description  = "";//描述
	@ModelProp(name="登记时间",colIndex=13)
	private String recordTime  = "";//登记时间
	@ModelProp(name="备注",colIndex=14)
	private String remark  = "";//备注
	
	
	private List<MealsRecordEntity> meals;//用餐记录
	private List<AccommodationRecordEntity> accom;//用餐记录
	
	
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

	public String getGuestNum() {
		return guestNum;
	}
	public void setGuestNum(String guestNum) {
		this.guestNum = guestNum;
	}
	public String getReceptionNum() {
		return receptionNum;
	}
	public void setReceptionNum(String receptionNum) {
		this.receptionNum = receptionNum;
	}
	public String getReceptionDays() {
		return receptionDays;
	}
	public void setReceptionDays(String receptionDays) {
		this.receptionDays = receptionDays;
	}
	public List<MealsRecordEntity> getMeals() {
		return meals;
	}
	public void setMeals(List<MealsRecordEntity> meals) {
		this.meals = meals;
	}
	public List<AccommodationRecordEntity> getAccom() {
		return accom;
	}
	public void setAccom(List<AccommodationRecordEntity> accom) {
		this.accom = accom;
	}
	
}
