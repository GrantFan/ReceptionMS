package com.reception.room.model;

import java.util.List;

import com.reception.util.poi.ModelProp;
import com.reception.util.poi.ModelTitle;

@ModelTitle(name="房间信息")
public class RoomInfoEntity {

	@ModelProp(name="ID",colIndex=0)
	private Integer id ;
	@ModelProp(name="酒店名称",colIndex=1)
	private String hotel;//所属酒店
	@ModelProp(name="房间号码",colIndex=2)
	private String roomNumber ;//房间号码
	@ModelProp(name="楼层",colIndex=3)
	private String floor;//楼层
	@ModelProp(name="房间朝向",colIndex=4)
	private String orientation;//房间朝向
	@ModelProp(name="房间类型",colIndex=5)
	private String roomType;//房间类型
	@ModelProp(name="特殊类型",colIndex=6)
	private String specialType;//特殊类型
	@ModelProp(name="配套设施",colIndex=7)
	private String supportFacilities;//配套设施
	@ModelProp(name="特色服务",colIndex=8)
	private String specialServe;//特色服务
	@ModelProp(name="外线电话",colIndex=9)
	private String outsidePhone;//外线电话
	@ModelProp(name="内线电话",colIndex=10)
	private String innerlinePhone;//内线电话
	@ModelProp(name="房间负责人",colIndex=11)
	private String responsiblePerson;//房间负责人
	@ModelProp(name="门市价",colIndex=12)
	private String rackPrice;//门市价
	@ModelProp(name="协议价",colIndex=13)
	private String agreementPrice;//协议价
	@ModelProp(name="是否含餐",colIndex=14)
	private String containFood;//是否含餐
	@ModelProp(name="房间状态",colIndex=15)
	private String state;//房间状态
	@ModelProp(name="备注",colIndex=16)
	private String remark;

	
	private List<RoomInfoEntity> list;

	
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

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public List<RoomInfoEntity> getList() {
		return list;
	}

	public void setList(List<RoomInfoEntity> list) {
		this.list = list;
	}

	
}
