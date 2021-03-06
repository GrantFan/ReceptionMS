package com.reception.recep.model;

import com.reception.util.poi.ModelProp;
import com.reception.util.poi.ModelTitle;

/*
 * 接待住房记录实体
 */
@ModelTitle(name="住房记录")
public class AccommodationRecordEntity {

	private String id;
	@ModelProp(name="接待编号",colIndex=0)
	private String receptionNumber;//接待编号
	@ModelProp(name="入住酒店",colIndex=1)
	private String hotel;//酒店
	@ModelProp(name="房间号",colIndex=2)
	private String roomNumber;//房间号
	@ModelProp(name="入住时间",colIndex=3)
	private String checkinTime;//入住时间
	@ModelProp(name="退房时间",colIndex=4)
	private String checkoutTime;//退房时间
	@ModelProp(name="宾客喜好",colIndex=5)
	private String hobby;//宾客喜好
	@ModelProp(name="登记时间",colIndex=6)
	private String recordTime;//登记时间
	@ModelProp(name="备注",colIndex=7)
	private String remark;
	
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReceptionNumber() {
		return receptionNumber;
	}
	public void setReceptionNumber(String receptionNumber) {
		this.receptionNumber = receptionNumber;
	}
	public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getCheckinTime() {
		return checkinTime;
	}
	public void setCheckinTime(String checkinTime) {
		this.checkinTime = checkinTime;
	}
	public String getCheckoutTime() {
		return checkoutTime;
	}
	public void setCheckoutTime(String checkoutTime) {
		this.checkoutTime = checkoutTime;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
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
	
}
