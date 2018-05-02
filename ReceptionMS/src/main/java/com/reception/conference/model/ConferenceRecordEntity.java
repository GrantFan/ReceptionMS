package com.reception.conference.model;


import java.util.Date;

/*** <p>Title:Conference_recordEntity </p> 
     <p>Description: 会意思详细信息</p> 
     <p>Company: </p>  
     @author Administrator
     @date 2018年4月16日下午3:37:42*/
public class ConferenceRecordEntity {
	
	private Integer id;
	//会议室使用编号
	private String use_number;
	//会议室名称
	private String conference_name;
	//酒店名称
	private String hotel;
	//使用日期
	private Date use_date;
	//开始时间
	private Date start_time;
	//结束时间
	private Date end_time;
	//用途说明
	private String purpose;
	//来宾人数
	private String guest_num;
	//
	private String remark;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUse_number() {
		return use_number;
	}
	public void setUse_number(String use_number) {
		this.use_number = use_number;
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
	public Date getUse_date() {
		return use_date;
	}
	public void setUse_date(Date use_date) {
		this.use_date = use_date;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getGuest_num() {
		return guest_num;
	}
	public void setGuest_num(String guest_num) {
		this.guest_num = guest_num;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
 
}