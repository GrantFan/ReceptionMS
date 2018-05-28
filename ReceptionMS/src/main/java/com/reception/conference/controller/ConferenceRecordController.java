package com.reception.conference.controller;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.reception.conference.api.IConferenceRecordService;
import com.reception.conference.model.ConferenceEntity;
import com.reception.conference.model.ConferenceRecordEntity;
import com.reception.conference.model.HotelUtil;
import com.reception.exceptionfilter.EntityNotFoundException;
import com.reception.util.JSONHelper;
import com.reception.util.poi.ImportExcelUtil;
 
@RestController
@RequestMapping(value="ConferenceRecordController")
public class ConferenceRecordController {
	
	@Resource
	private IConferenceRecordService conferenceRecordServiceImpl;
	
	@RequestMapping(value = "addConferenceRecord",method = RequestMethod.POST)
	public String addConferenceRecord(ConferenceRecordEntity conferenceRecordEntity){
		
		Boolean flag = this.conferenceRecordServiceImpl.checkConferenceRecord(conferenceRecordEntity); 
		
		if(flag){ 
			this.conferenceRecordServiceImpl.addConferenceRecord(conferenceRecordEntity); 
			return flag.toString();
		}else{
			return flag.toString(); 
		} 
	}
	@RequestMapping(value = "delConferenceRecord/{id}",method = RequestMethod.DELETE)
	public String delConferenceRecord(String id){
		boolean flag =  this.conferenceRecordServiceImpl.delConferenceRecord(id);  
		return JSONHelper.toJSON(flag);
	}	 
	@RequestMapping(value = "modConferenceRecord",method = RequestMethod.POST)
	public String modConferenceRecord(ConferenceRecordEntity conferenceRecordEntity){
		Boolean flag = this.conferenceRecordServiceImpl.checkConferenceRecord(conferenceRecordEntity); 
		
		if(flag){ 
			this.conferenceRecordServiceImpl.modConferenceRecord(conferenceRecordEntity);  
			return flag.toString();
		}else{
			return flag.toString(); 
		}  
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
	public String queryConferenceRecordByPage(
			@RequestParam(value="pageNum",required = false,defaultValue = "1")   int pageNum,
			@RequestParam(value="pageSize",required = false,defaultValue = "10") int pageSize,
			@RequestParam(value="hotelName",required = false) String hotelName,
			@RequestParam(value="conference_name",required = false) String conference_name,
			@RequestParam(value="begin_DATE",required = false) String begin_DATE,
			@RequestParam(value="end_DATE",required = false) String end_DATE){
		PageHelper.startPage(pageNum, pageSize);  
		Map map = new HashMap(4);
		map.put("hotelName", hotelName);
		map.put("conference_name", conference_name);
		map.put("begin_DATE", begin_DATE);
		map.put("end_DATE", end_DATE);
		List<ConferenceRecordEntity> list =  this.conferenceRecordServiceImpl.queryConferenceRecordByPage(map);  
		PageInfo<ConferenceRecordEntity> pageInfo = new PageInfo<ConferenceRecordEntity>(list);   
		return JSONHelper.toJSON(pageInfo);
	}
	@RequestMapping(value = "queryConferenceRecordList",method = RequestMethod.GET)
	public String queryConferenceRecordList(
			@RequestParam(required = false)String hotelName,
			@RequestParam(required = false)String confernce_TYPE,
			@RequestParam(required = true)String date){
		Map map = new HashMap(4); 
		Date now_date = new Date();  
	    DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String nowtime = format.format(now_date); 
	    map.put("hotelName", hotelName == null ? "" : hotelName.trim());
		map.put("CONFERENCE_TYPE", confernce_TYPE == null ? "" : confernce_TYPE.trim());
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
	@RequestMapping(value = "export",method = RequestMethod.GET)
	public void queryConferenectExport( 
			HttpServletResponse res,
			@RequestParam(value="hotelName",required = false) String hotelName,
			@RequestParam(value="conference_name",required = false) String conference_name,
			@RequestParam(value="begin_DATE",required = false) String begin_DATE,
			@RequestParam(value="end_DATE",required = false) String end_DATE){
		
		Map map = new HashMap(4);
		map.put("hotelName", hotelName);
		map.put("conference_name", conference_name);
		map.put("begin_DATE", begin_DATE);
		map.put("end_DATE", end_DATE);
		
		res.setContentType("application/xls");
		try {
			res.addHeader("Content-Disposition", "attachment;filename="+new String(("会议室使用登记表").getBytes("UTF-8"),"iso-8859-1")+".xls");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<ConferenceRecordEntity> list =  this.conferenceRecordServiceImpl.queryConferenceRecordByPage(map);   
		BufferedInputStream input = new  BufferedInputStream(ImportExcelUtil.excelModelbyClass(ConferenceRecordEntity.class, null, null,list));
		byte buffBytes[] = new byte[1024];
		OutputStream os;
		try {
			os = res.getOutputStream();
			int read = 0;
			while ((read = input.read(buffBytes)) != -1) {
				os.write(buffBytes, 0, read);
			}
			os.flush();
			os.close();
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
