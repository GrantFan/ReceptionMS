package com.reception.conference.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.reception.conference.api.IConferenceRecordService;
import com.reception.conference.dao.ConferenceRecordMapper;
import com.reception.conference.model.ConferenceRecordEntity;

@Service
public class ConferenceRecordServiceImpl implements IConferenceRecordService{
	
	@Resource
	private ConferenceRecordMapper conferenceRecordMapper;
	
	@Override
	public void addConferenceRecord(ConferenceRecordEntity conferenceRecordEntity) {
		this.conferenceRecordMapper.addConferenectRecord(conferenceRecordEntity); 
	}

	@Override
	public boolean delConferenceRecord(String id) {
		return this.conferenceRecordMapper.delConferenectRecord(id) == 1 ? true : false;
		
	}

	@Override
	public boolean modConferenceRecord(Integer id) {
		return this.conferenceRecordMapper.modConferenectRecord(id) == 1 ? true : false;
	}

	@Override
	public ConferenceRecordEntity queryConferenceRecordById(Integer id) { 
		return this.queryConferenceRecordById(id);
	}

	@Override
	public List<ConferenceRecordEntity> queryConferenceRecordByPage() {
		 return this.queryConferenceRecordByPage();
	}

}
