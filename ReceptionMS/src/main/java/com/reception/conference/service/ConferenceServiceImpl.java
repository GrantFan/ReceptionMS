package com.reception.conference.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.reception.conference.api.IConferenceService;
import com.reception.conference.dao.ConferenceMapper;
import com.reception.conference.model.ConferenceEntity;
import com.reception.util.FileUtil;


 

@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })	
public class ConferenceServiceImpl implements IConferenceService{
	
	private static Logger log = org.slf4j.LoggerFactory.getLogger(ConferenceServiceImpl.class);
	 
	@Resource 
	ConferenceMapper conferenceMapper;
   
	@Resource
	FileUtil fileUtil;
	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void addConferenect(ConferenceEntity conferenceEntity, MultipartFile file) {
		    
		conferenceEntity.setId(String.valueOf((System.currentTimeMillis())));
		
		this.conferenceMapper.addConferenect(conferenceEntity); 
	} 
	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public boolean delConferenect(String id) {
		return this.conferenceMapper.delConferenect(id) == 1 ? true : false;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public boolean modConferenect(ConferenceEntity conferenceEntity) {
		return this.conferenceMapper.modConferenect(conferenceEntity) == 1 ? true : false;
	}

	@Override
	public ConferenceEntity queryConferenectById(String id) {
		return this.conferenceMapper.queryConferenectById(id);
	}

	@Override
	public List<ConferenceEntity> queryConferenectByPage() {
		return this.conferenceMapper.queryConferenectByPage();
	}
 
	
}
