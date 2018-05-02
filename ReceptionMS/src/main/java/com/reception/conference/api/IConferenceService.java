package com.reception.conference.api;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.reception.conference.model.ConferenceEntity;


public interface IConferenceService {

	public void addConferenect(ConferenceEntity conferenceEntity, MultipartFile file);
	

	public boolean delConferenect(String id);
	
	
	public boolean modConferenect(ConferenceEntity conferenceEntity);

	public ConferenceEntity queryConferenectById(String id);
	 
	public List<ConferenceEntity> queryConferenectByPage();
	 
}
