package com.reception.conference.model;


import java.util.Date;

/*** <p>Title:Conference_recordEntity </p> 
     <p>Description: 会意思详细信息</p> 
     <p>Company: </p>  
     @author Administrator
     @date 2018年4月16日下午3:37:42*/
public class ConferenceRecordEntity {
	
	private String ID;
	//会议室使用编号
	private String USE_NUMBER;
	//会议室名称
	private String CONFERENCE_NAME;
	//酒店名称
	private String HOTEL;
	//使用日期
	private String USE_DATE;
	//开始时间
	private String START_TIME;
	//结束时间
	private String END_TIME;
	//用途说明
	private String PURPOSE;
	//来宾人数
	private String GUEST_NUM;
	//
	private String REMARK;
	
	private String CONFERENCE_TYPE;
	
	private String START_DATE;
	
	private String END_DATE;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getUSE_NUMBER() {
		return USE_NUMBER;
	}

	public void setUSE_NUMBER(String uSE_NUMBER) {
		USE_NUMBER = uSE_NUMBER;
	}

	public String getCONFERENCE_NAME() {
		return CONFERENCE_NAME;
	}

	public void setCONFERENCE_NAME(String cONFERENCE_NAME) {
		CONFERENCE_NAME = cONFERENCE_NAME;
	}

	public String getHOTEL() {
		return HOTEL;
	}

	public void setHOTEL(String hOTEL) {
		HOTEL = hOTEL;
	}
  
	public String getUSE_DATE() {
		return USE_DATE;
	}

	public void setUSE_DATE(String uSE_DATE) {
		USE_DATE = uSE_DATE;
	}

	public String getSTART_TIME() {
		return START_TIME;
	}

	public void setSTART_TIME(String sTART_TIME) {
		START_TIME = sTART_TIME;
	}

	public String getEND_TIME() {
		return END_TIME;
	}

	public void setEND_TIME(String eND_TIME) {
		END_TIME = eND_TIME;
	}

	public String getPURPOSE() {
		return PURPOSE;
	}

	public void setPURPOSE(String pURPOSE) {
		PURPOSE = pURPOSE;
	}

	public String getGUEST_NUM() {
		return GUEST_NUM;
	}

	public void setGUEST_NUM(String gUEST_NUM) {
		GUEST_NUM = gUEST_NUM;
	}

	public String getREMARK() {
		return REMARK;
	}

	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
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