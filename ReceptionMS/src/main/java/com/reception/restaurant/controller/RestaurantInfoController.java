package com.reception.restaurant.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.reception.exceptionfilter.EntityNotFoundException;
import com.reception.restaurant.api.IRestaurantInfoService;
import com.reception.restaurant.model.RestaurantInfoEntity;
import com.reception.restaurant.model.RestaurantUtilEntity;
import com.reception.util.JSONHelper;
import com.reception.util.poi.ImportExcelUtil;

@RestController
@RequestMapping(value="RestaurantInfoController" ,produces = "application/json;charset=UTF-8")
public class RestaurantInfoController {
	
	@Resource
	private IRestaurantInfoService iRestaurantInfoService;
	
	@RequestMapping(method = RequestMethod.POST)
	public void addRestaurantInfo(@ModelAttribute("RestaurantInfoEntity")RestaurantInfoEntity restaurantInfoEntity){
		this.iRestaurantInfoService.addRestaurantInfo(restaurantInfoEntity); 
	}
	@RequestMapping(value = "delRestaurantInfo",method = RequestMethod.POST)
	public String delRestaurantInfo(@RequestParam(value="idArray[]")String[] idArray){ 
		boolean flag =  this.iRestaurantInfoService.delRestaurantInfo(idArray);  
		return JSONHelper.toJSON(flag);
	}	 
	@RequestMapping(method = RequestMethod.PUT)
	public String modRestaurantInfo(@ModelAttribute("RestaurantInfoEntity")RestaurantInfoEntity RestaurantInfoEntity){
		boolean flag =  this.iRestaurantInfoService.modRestaurantInfo(RestaurantInfoEntity);  
		return JSONHelper.toJSON(flag);
	}
	@RequestMapping(value = "{id}",method = RequestMethod.GET)
	public String queryRestaurantInfoById(@PathVariable("id")String id){
		RestaurantInfoEntity RestaurantInfoEntity =  this.iRestaurantInfoService.queryRestaurantInfoById(id);  
		if(RestaurantInfoEntity == null){
			new EntityNotFoundException("不存在"); 
		}
		return JSONHelper.toJSON(RestaurantInfoEntity);
	}
	@RequestMapping(method = RequestMethod.GET)
	public String queryRestaurantInfoByPage(
			@RequestParam(value="pageNum",required = false,defaultValue = "1")   int pageNum,
			@RequestParam(value="pageSize",required = false,defaultValue = "10") int pageSize,
			@RequestParam(value="hotel",required = false) String hotel,
			@RequestParam(value="restaurantType",required = false) String restaurantType){
		PageHelper.startPage(pageNum, pageSize);  
		Map map = new HashMap(2);
		map.put("hotel", hotel);
		map.put("restaurantType", restaurantType);
		List<RestaurantInfoEntity> list =  this.iRestaurantInfoService.queryRestaurantInfoByPage(map);  
		PageInfo<RestaurantInfoEntity> pageInfo = new PageInfo<RestaurantInfoEntity>(list);   
		return JSONHelper.toJSON(pageInfo);
	}
	@RequestMapping(value="queryRestaurantInfo.app",method = RequestMethod.GET)
	public String queryRestaurantInfoByPage( 
			@RequestParam(value="hotel",required = false) String hotel,HttpServletResponse response,
			@RequestParam(value="restaurantType",required = false) String restaurantType){ 
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map map = new HashMap(2);
		map.put("hotel", hotel);
		map.put("restaurantType", restaurantType);
		List<RestaurantInfoEntity> list =  this.iRestaurantInfoService.queryRestaurantInfoByPage(map);      
		return JSONHelper.toJSON(list);
	}
	@RequestMapping(value = "export",method = RequestMethod.GET)
	public void queryRestaurantInfoExport( 
			HttpServletResponse res,
			@RequestParam(value="hotel",required = false) String hotel,
			@RequestParam(value="boardType",required = false) String boardType){
		Map map = new HashMap(2);
		map.put("hotel", hotel);
		map.put("boardType", boardType);
		
		res.setContentType("application/xls");
		try {
			res.addHeader("Content-Disposition", "attachment;filename="+new String(("餐厅基本信息").getBytes("UTF-8"),"iso-8859-1")+".xls");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<RestaurantInfoEntity> list =  this.iRestaurantInfoService.queryRestaurantInfoByPage(map);  
		BufferedInputStream input = new  BufferedInputStream(ImportExcelUtil.excelModelbyClass(RestaurantInfoEntity.class, null, null,list));
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
	 
	@RequestMapping(value="/restaurantTypeList",method = RequestMethod.GET)
	public String restaurantTypeList(
			@RequestParam(value="hotel_name")String hotel_name){ 
		List<RestaurantUtilEntity> list =  this.iRestaurantInfoService.restaurantUtilEntity(hotel_name);  
		return JSONHelper.toJSON(list);
	}
	
	@RequestMapping(value="/getrestaurant_number",method = RequestMethod.GET)
	public String getrestaurant_number(){ 
		String number =  this.iRestaurantInfoService.getrestaurant_number();  
		return JSONHelper.toJSON(number);
	}
	
}
