package com.reception.room.model;

import com.reception.hotel.model.HotelInfoEntity;

public class RoomInfoEntity {

	private Integer id ;
	private String roomNumber ;//房间号码
	private String floor;//楼层
	private String orientation;//房间朝向
	private String outsidePhone;//外线电话
	private String innerlinePhone;//内线电话
	private String responsiblePerson;//房间负责人
	private String rackPrice;//门市价
	private String agreementPrice;//协议价
	private String containFood;//是否含餐
	private String state;//房间状态
	private String roomType;//房间类型
	private String specialType;//特殊类型
	private String supportFacilities;//配套设施
	private String specialServe;//特色服务
	private String remark;
	
	private HotelInfoEntity hotel;

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public String getOutsidePhone() {
		return outsidePhone;
	}

	public void setOutsidePhone(String outsidePhone) {
		this.outsidePhone = outsidePhone;
	}

	public String getInnerlinePhone() {
		return innerlinePhone;
	}

	public void setInnerlinePhone(String innerlinePhone) {
		this.innerlinePhone = innerlinePhone;
	}

	public String getResponsiblePerson() {
		return responsiblePerson;
	}

	public void setResponsiblePerson(String responsiblePerson) {
		this.responsiblePerson = responsiblePerson;
	}

	public String getRackPrice() {
		return rackPrice;
	}

	public void setRackPrice(String rackPrice) {
		this.rackPrice = rackPrice;
	}

	public String getAgreementPrice() {
		return agreementPrice;
	}

	public void setAgreementPrice(String agreementPrice) {
		this.agreementPrice = agreementPrice;
	}

	public String getContainFood() {
		return containFood;
	}

	public void setContainFood(String containFood) {
		this.containFood = containFood;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getSpecialType() {
		return specialType;
	}

	public void setSpecialType(String specialType) {
		this.specialType = specialType;
	}

	public String getSupportFacilities() {
		return supportFacilities;
	}

	public void setSupportFacilities(String supportFacilities) {
		this.supportFacilities = supportFacilities;
	}

	public String getSpecialServe() {
		return specialServe;
	}

	public void setSpecialServe(String specialServe) {
		this.specialServe = specialServe;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public HotelInfoEntity getHotel() {
		return hotel;
	}

	public void setHotel(HotelInfoEntity hotel) {
		this.hotel = hotel;
	}
	
	
}
