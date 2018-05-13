package com.reception.conference.api;

import java.util.List;
import java.util.Map;

import com.reception.conference.model.ConferenceEntity;


public interface IConferenceService {

	public void addConferenect(ConferenceEntity conferenceEntity);
	

	public boolean delConferenect(String[] id);
	
	
	public boolean modConferenect(ConferenceEntity conferenceEntity);

	public ConferenceEntity queryConferenectById(String id);
	 
	public List<ConferenceEntity> queryConferenectByPage(Map map);
	 
	public List<ConferenceEntity> queryConferenectList(String hotel_name);
}
