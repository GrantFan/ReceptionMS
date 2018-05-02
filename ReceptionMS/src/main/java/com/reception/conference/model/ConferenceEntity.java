package com.reception.conference.model;

import com.reception.util.poi.ModelProp;
import com.reception.util.poi.ModelTitle;

/**
 * * <p>Title:ConferenceEntity </p> 
     <p>Description: 会议室基本信息 </p> 
     <p>Company: </p>  
     @author wangyanghai
     @date 2018年4月16日下午3:34:54
 */
@ModelTitle(name = "会议室基本信息")
public class ConferenceEntity {
	
	private String id;
	@ModelProp(name = "会议室名字",colIndex = 3)
	private String conference_name;
	//所属酒店
	@ModelProp(name = "所属酒店",colIndex = 2)
	private String hotel; 
	//会议室类型
	@ModelProp(name = "会议室类型",colIndex = 1)
	private String type;
	//position
	@ModelProp(name = "位置",colIndex = 4)
	private String position;
	//capacity_num
	@ModelProp(name = "人数",colIndex = 5)
	private String capacity_num;
	//备注
	@ModelProp(name = "备注",colIndex = 6)
	private String remark;

	private String img_uri;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	              
	public String getConference_name() {
		return conference_name;
	}

	public void setConference_name(String conference_name) {
		this.conference_name = conference_name;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCapacity_num() {
		return capacity_num;
	}

	public void setCapacity_num(String capacity_num) {
		this.capacity_num = capacity_num;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}  
	
	public String getImg_uri() {
		return img_uri;
	}

	public void setImg_uri(String img_uri) {
		this.img_uri = img_uri;
	}

	@Override
	public String toString(){
		return  "  id is " + this.getId() +
				"\n  Conference_name is " + this.getConference_name() +
				"\n  Hotel is " + this.getHotel() +
				"\n  Type is " + this.getType() +
				"\n  Position is " + this.getPosition() +
				"\n  Capacity_num is " + this.getCapacity_num() +
				"\n  Remark is " + this.getRemark() ;
	}
}
