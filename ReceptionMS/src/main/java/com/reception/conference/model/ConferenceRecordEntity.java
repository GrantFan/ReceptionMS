package com.reception.conference.model;


import java.util.Date;

import com.reception.util.poi.ModelProp;
import com.reception.util.poi.ModelTitle;

/*** <p>Title:Conference_recordEntity </p> 
     <p>Description: 会意思详细信息</p> 
     <p>Company: </p>  
     @author Administrator
     @date 2018年4月16日下午3:37:42*/
@ModelTitle(name = "会议室使用信息")
public class ConferenceRecordEntity {
	
	private String Id;
	//会议室使用编号
	@ModelProp(name = "会议室使用编号",colIndex = 1)
	private String Use_number;
	//会议室名称
	@ModelProp(name = "会议室名称",colIndex = 2)
	private String Conference_name;
	//酒店名称
	@ModelProp(name = "酒店名称",colIndex = 3)
	private String Hotel;
	//使用日期
	@ModelProp(name = "使用日期",colIndex = 4)
	private String Use_date;
	//开始时间
	@ModelProp(name = "开始时间",colIndex = 5)
	private String Start_time;
	//结束时间
	@ModelProp(name = "结束时间",colIndex = 6)
	private String End_time;
	//用途说明
	@ModelProp(name = "用途说明",colIndex = 7)
	private String Purpose;
	//来宾人数
	@ModelProp(name = "来宾人数",colIndex = 8)
	private String Guest_num;
	//
	@ModelProp(name = "备注",colIndex = 9)
	private String Remark;
	
	private String CONFERENCE_TYPE;
	
	private String START_DATE;
	
	private String END_DATE;

	
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getUse_number() {
		return Use_number;
	}

	public void setUse_number(String use_number) {
		Use_number = use_number;
	}

	public String getConference_name() {
		return Conference_name;
	}

	public void setConference_name(String conference_name) {
		Conference_name = conference_name;
	}

	public String getHotel() {
		return Hotel;
	}

	public void setHotel(String hotel) {
		Hotel = hotel;
	}

	public String getUse_date() {
		return Use_date;
	}

	public void setUse_date(String use_date) {
		Use_date = use_date;
	}

	public String getStart_time() {
		return Start_time;
	}

	public void setStart_time(String start_time) {
		Start_time = start_time;
	}

	public String getEnd_time() {
		return End_time;
	}

	public void setEnd_time(String end_time) {
		End_time = end_time;
	}

	public String getPurpose() {
		return Purpose;
	}

	public void setPurpose(String purpose) {
		Purpose = purpose;
	}

	public String getGuest_num() {
		return Guest_num;
	}

	public void setGuest_num(String guest_num) {
		Guest_num = guest_num;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}

	public String getCONFERENCE_TYPE() {
		return CONFERENCE_TYPE;
	}

	public void setCONFERENCE_TYPE(String cONFERENCE_TYPE) {
		CONFERENCE_TYPE = cONFERENCE_TYPE;
	}

	public String getSTART_DATE() {
		return START_DATE;
	}

	public void setSTART_DATE(String sTART_DATE) {
		START_DATE = sTART_DATE;
	}

	public String getEND_DATE() {
		return END_DATE;
	}

	public void setEND_DATE(String eND_DATE) {
		END_DATE = eND_DATE;
	} 
 
}