package com.reception.conference.controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.reception.conference.model.HotelUtil;
import com.reception.exceptionfilter.EntityNotFoundException;
import com.reception.util.JSONHelper;
 
@RestController
@RequestMapping(value="ConferenceRecordController")
public class ConferenceRecordController {
	
	@Resource
	private IConferenceRecordService conferenceRecordServiceImpl;
	
	@RequestMapping(value = "addConferenceRecord",method = RequestMethod.POST)
	public String addConferenceRecord(ConferenceRecordEntity conferenceRecordEntity){
		
		boolean flag = this.conferenceRecordServiceImpl.checkConferenceRecord(conferenceRecordEntity); 
		
		if(flag){ 
//			this.conferenceRecordServiceImpl.addConferenceRecord(conferenceRecordEntity); 
			return "新增成功";
		}else{
			return "该时间已被预订"; 
		} 
	}
	@RequestMapping(value = "delConferenceRecord/{id}",method = RequestMethod.DELETE)
	public String delConferenceRecord(String id){
		boolean flag =  this.conferenceRecordServiceImpl.delConferenceRecord(id);  
		return JSONHelper.toJSON(flag);
	}	 
	@RequestMapping(value = "modConferenceRecord",method = RequestMethod.PUT)
	public String modConferenceRecord(ConferenceRecordEntity conferenceRecordEntity){
		boolean flag =  this.conferenceRecordServiceImpl.modConferenceRecord(conferenceRecordEntity);  
		return JSONHelper.toJSON(flag);
	}
	@RequestMapping(value = "queryConferenceRecordById/{id}",method = RequestMethod.GET)
	public String queryConferenceRecordById(@PathVariable("id")String id){
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
	@RequestMapping(value = "queryConferenceRecordList",method = RequestMethod.GET)
	public String queryConferenceRecordList(
			@RequestParam(required = false)String hotelName,
			@RequestParam(required = false)String confernce_TYPE,
			@RequestParam(required = true)String date){
		Map map = new HashMap(3);
		 
		Date now_date = new Date();  
	    DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String nowtime = format.format(now_date);
		 
		map.put("hotelName", hotelName.trim());
		map.put("CONFERENCE_TYPE", confernce_TYPE.trim());
		map.put("date", date);
		map.put("nowtime", nowtime);
		
		List<HotelUtil> list =  this.conferenceRecordServiceImpl.hotelList(map);  
		return JSONHelper.toJSON(list);
	}
	
	@RequestMapping(value = "getUse_Number",method = RequestMethod.POST)
	public String getUse_Number(){
		Date now_date = new Date();  
        DateFormat format=new SimpleDateFormat("yyyyMMdd");  
		String  use_Number =  this.conferenceRecordServiceImpl.getUse_Number(format.format(now_date));  
		return use_Number;
	}
	
	
}
