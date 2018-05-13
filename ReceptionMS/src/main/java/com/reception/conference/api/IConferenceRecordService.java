package com.reception.conference.api;

import java.util.List;
import java.util.Map;

import com.reception.conference.model.ConferenceRecordEntity;
import com.reception.conference.model.HotelUtil;


public interface IConferenceRecordService {
		
	public void addConferenceRecord(ConferenceRecordEntity conferenceRecordEntity);
	

	public boolean delConferenceRecord(String id);
	
	
	public boolean modConferenceRecord(ConferenceRecordEntity conferenceRecordEntity);

	public ConferenceRecordEntity queryConferenceRecordById(String id);
	
	
	public List<ConferenceRecordEntity> queryConferenceRecordByPage();
	
	public List<HotelUtil> hotelList(Map map);
	
	public String getUse_Number(String now_date);
	
	public boolean checkConferenceRecord(ConferenceRecordEntity conferenceRecordEntity);
}
