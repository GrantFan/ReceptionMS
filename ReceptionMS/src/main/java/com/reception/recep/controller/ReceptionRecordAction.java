package com.reception.recep.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.reception.hotel.model.HotelInfoEntity;
import com.reception.recep.api.AccommodationRecordService;
import com.reception.recep.api.MealsRecordService;
import com.reception.recep.model.AccommodationRecordEntity;
import com.reception.recep.model.MealsRecordEntity;
import com.reception.recep.model.ReceptionRecordEntity;
import com.reception.recep.service.ReceptionRecordServiceImpl;
import com.reception.util.JSONHelper;

@RestController
@RequestMapping(value="/recep")
public class ReceptionRecordAction {

	@Resource
	ReceptionRecordServiceImpl receptionRecordServiceImpl;
	@Resource
	AccommodationRecordService accommodationRecordService;
	@Resource
	MealsRecordService mealsRecordService;
	
	@RequestMapping(value="/list",produces="application/text; charset=utf-8")
	public @ResponseBody String receptionRecordList(@RequestParam(value="pageSize")String pageSize,@RequestParam(value="pageNum")String pageNum){
		PageHelper.startPage(Integer.valueOf(pageNum), Integer.valueOf(pageSize));
		List<ReceptionRecordEntity> list = receptionRecordServiceImpl.selectList();
		PageInfo<ReceptionRecordEntity> pageInfo = new PageInfo<ReceptionRecordEntity>(list); 
		String json = JSONHelper.toJSON(pageInfo);
		System.out.println(json);
		return json;
	}
	
	@RequestMapping(value="/recordInfo",produces="application/text; charset=utf-8")
	public @ResponseBody String receptionRecord(@RequestParam(value="receptionNumber")String receptionNumber){
		
		List<ReceptionRecordEntity> list = receptionRecordServiceImpl.selectByNumber(receptionNumber);
		ReceptionRecordEntity reception = list.get(0);
		List<AccommodationRecordEntity> acclist = accommodationRecordService.selectByReceptionNumber(receptionNumber);
		List<MealsRecordEntity> meallist = mealsRecordService.selectByReceptionNumber(receptionNumber);
		Map map = new HashMap<String, Object>();
		map.put("reception", reception);
		map.put("accommodation", acclist);
		map.put("meals", meallist);
		String json = JSONHelper.toJSON(map);
		System.out.println(json);
		return json;
	}
}
