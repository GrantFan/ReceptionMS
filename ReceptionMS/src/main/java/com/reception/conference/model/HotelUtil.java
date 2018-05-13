package com.reception.conference.model;

import java.util.List;

public class HotelUtil {
	private String id;
	
	private String name;
	
	private List<ConferenceRecordEntity> ConferenceRecordList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ConferenceRecordEntity> getConferenceRecordList() {
		return ConferenceRecordList;
	}

	public void setConferenceRecordList(List<ConferenceRecordEntity> conferenceRecordList) {
		ConferenceRecordList = conferenceRecordList;
	} 
}
