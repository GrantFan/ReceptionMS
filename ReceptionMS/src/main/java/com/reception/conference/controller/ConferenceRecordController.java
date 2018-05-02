package com.reception.conference.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.reception.conference.api.IConferenceRecordService;
import com.reception.conference.model.ConferenceRecordEntity;
import com.reception.exceptionfilter.EntityNotFoundException;
import com.reception.util.JSONHelper;
 
@RestController
@RequestMapping(value= "ConferenceRecordController" ,produces = "application/json;charset=UTF-8")
public class ConferenceRecordController {
	
	@Resource
	private IConferenceRecordService conferenceRecordServiceImpl;
	
	@RequestMapping(method = RequestMethod.POST)
	public void addConferenceRecord(ConferenceRecordEntity conferenceRecordEntity){
		this.conferenceRecordServiceImpl.addConferenceRecord(conferenceRecordEntity); 
	}
	@RequestMapping(value = "{/id}",method = RequestMethod.DELETE)
	public String delConferenceRecord(@PathVariable("id")String id){
		boolean flag =  this.conferenceRecordServiceImpl.delConferenceRecord(id);  
		return JSONHelper.toJSON(flag);
	}	 
	@RequestMapping(value = "{id}",method = RequestMethod.PUT)
	public String modConferenceRecord(@PathVariable("id")Integer id){
		boolean flag =  this.conferenceRecordServiceImpl.modConferenceRecord(id);  
		return JSONHelper.toJSON(flag);
	}
	@RequestMapping(value = "{id}",method = RequestMethod.GET)
	public String queryConferenceRecordById(@PathVariable("id")Integer id){
		ConferenceRecordEntity conferenceRecordEntity =  this.conferenceRecordServiceImpl.queryConferenceRecordById(id);  
		if(conferenceRecordEntity == null){
			new EntityNotFoundException("不存在"); 
		}
		return JSONHelper.toJSON(conferenceRecordEntity);
	}
	@RequestMapping(value = "queryConferenceRecordByPage",method = RequestMethod.GET)
	public String queryConferenceRecordByPage(@RequestParam(required = true)int pageNum,
			@RequestParam(required = true)int pageSize){
		PageHelper.startPage(pageNum, pageSize);  
		List<ConferenceRecordEntity> list =  this.conferenceRecordServiceImpl.queryConferenceRecordByPage();  
		PageInfo<ConferenceRecordEntity> pageInfo = new PageInfo<ConferenceRecordEntity>(list);  
		System.out.println(JSONHelper.toJSON(pageInfo)); 
		return JSONHelper.toJSON(pageInfo);
	}
	
	
	
}
