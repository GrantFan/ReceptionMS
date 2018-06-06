package com.reception.conference.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.reception.conference.api.IConferenceService;
import com.reception.conference.model.ConferenceEntity;
import com.reception.exceptionfilter.EntityNotFoundException;
import com.reception.util.JSONHelper;
import com.reception.util.poi.ImportExcelUtil;


@RestController
@RequestMapping(value= "ConferenceController" ,produces = "application/json;charset=UTF-8")
public class ConferenceController {

	private static Logger log=LoggerFactory.getLogger(ConferenceController.class);

	@Resource
	IConferenceService ConferenceServiceImpl;

	@RequestMapping(method = RequestMethod.POST)
	public void addConferenect(@ModelAttribute("conferenceEntity")ConferenceEntity conferenceEntity){
		this.ConferenceServiceImpl.addConferenect(conferenceEntity); 
	}
	@RequestMapping(value = "delConferenect",method = RequestMethod.POST)
	public String delConferenect(@RequestParam(value="idArray[]")String[] idArray){ 
		boolean flag =  this.ConferenceServiceImpl.delConferenect(idArray);  
		return JSONHelper.toJSON(flag);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public String modConferenect(@ModelAttribute("conferenceEntity")ConferenceEntity conferenceEntity,HttpServletRequest request){
		boolean flag =  this.ConferenceServiceImpl.modConferenect(conferenceEntity);  
		return JSONHelper.toJSON(flag);
	}
	@RequestMapping(value = "{id}",method = RequestMethod.GET)
	public String queryConferenectById(@PathVariable("id")String id){
		ConferenceEntity conferenceEntity =  this.ConferenceServiceImpl.queryConferenectById(id);  
		if(conferenceEntity == null){
			new EntityNotFoundException("不存在"); 
		}
		return JSONHelper.toJSON(conferenceEntity);
	}
	@RequestMapping(method = RequestMethod.GET)
	public String queryConferenectByPage(
			@RequestParam(value="pageNum",required = false,defaultValue = "1")   int pageNum,
			@RequestParam(value="pageSize",required = false,defaultValue = "10") int pageSize,
			@RequestParam(value="hotel",required = false) String hotel,
			@RequestParam(value="boardType",required = false) String boardType,
			HttpServletRequest req){
		PageHelper.startPage(pageNum, pageSize);  
		Map map = new HashMap(2);
		map.put("hotel", hotel);
		map.put("boardType", boardType);
		List<ConferenceEntity> list =  this.ConferenceServiceImpl.queryConferenectByPage(map);   
		PageInfo<ConferenceEntity> pageInfo = new PageInfo<ConferenceEntity>(list);  
	 
		return JSONHelper.toJSON(pageInfo);
	}
	@RequestMapping(value="/queryConferenect.app",method = RequestMethod.GET)
	public String queryConferenectByPage( 
			@RequestParam(value="hotel",required = false) String hotel,
			@RequestParam(value="boardType",required = false) String boardType,
			HttpServletRequest req,HttpServletResponse response){ 
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map map = new HashMap(2);
		map.put("hotel", hotel);
		map.put("boardType", boardType);
		List<ConferenceEntity> list =  this.ConferenceServiceImpl.queryConferenectByPage(map);   
		return JSONHelper.toJSON(list);
	}
	@RequestMapping(value = "export",method = RequestMethod.GET)
	public void queryConferenectExport( 
			HttpServletResponse res,
			@RequestParam(value="hotel",required = false) String hotel,
			@RequestParam(value="boardType",required = false) String boardType){
		Map map = new HashMap(2);
		map.put("hotel", hotel);
		map.put("boardType", boardType);
		
		res.setContentType("application/xls");
		try {
			res.addHeader("Content-Disposition", "attachment;filename="+new String(("eeelist").getBytes("UTF-8"),"iso-8859-1")+".xls");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<ConferenceEntity> list =  this.ConferenceServiceImpl.queryConferenectByPage(map);  
		BufferedInputStream input = new  BufferedInputStream(ImportExcelUtil.excelModelbyClass(ConferenceEntity.class, null, null,list));
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
	
	@RequestMapping(value = "queryConferenectList",method = RequestMethod.GET)
	public String queryConferenectList(
			@RequestParam(value="hotel_name")String hotel_name){
		return JSONHelper.toJSON(this.ConferenceServiceImpl.queryConferenectList(hotel_name.trim()));
	}

}
