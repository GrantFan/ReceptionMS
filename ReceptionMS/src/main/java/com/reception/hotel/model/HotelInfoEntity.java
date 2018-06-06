package com.reception.hotel.model;

import com.reception.util.poi.ModelProp;
import com.reception.util.poi.ModelTitle;

@ModelTitle(name="酒店信息")
public class HotelInfoEntity {

//	@ModelProp(name="ID")
	private Integer id ;
	@ModelProp(name="酒店名称",colIndex=0)
	private String hotelName ;
	@ModelProp(name="酒店联系人",colIndex=1)
	private String linkman;
	@ModelProp(name="联系电话",colIndex=2)
	private String telphone;
	@ModelProp(name="座机",colIndex=3)
	private String phone;
	@ModelProp(name="所属行政区",colIndex=4)
	private String area;
	@ModelProp(name="酒店地址",colIndex=5)
	private String address;
	@ModelProp(name="酒店平面图路径",colIndex=6)
	private String planeGraph="";
	@ModelProp(name="备注",colIndex=7)
	private String remark;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPlaneGraph() {
		return planeGraph;
	}
	public void setPlaneGraph(String planeGraph) {
		this.planeGraph = planeGraph;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	
}
