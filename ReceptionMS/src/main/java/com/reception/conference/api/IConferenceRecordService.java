package com.reception.conference.api;

import java.util.List;

import com.reception.conference.model.ConferenceRecordEntity;


public interface IConferenceRecordService {
		
	public void addConferenceRecord(ConferenceRecordEntity conferenceRecordEntity);
	

	public boolean delConferenceRecord(String id);
	
	
	public boolean modConferenceRecord(Integer id);

	public ConferenceRecordEntity queryConferenceRecordById(Integer id);
	
	
	public List<ConferenceRecordEntity> queryConferenceRecordByPage();
	
}
