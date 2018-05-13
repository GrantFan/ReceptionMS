package com.reception.recep.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
	public @ResponseBody String receptionRecordList(
			@RequestParam(value="pageSize",required = false,defaultValue = "5")String pageSize,
			@RequestParam(value="pageNum",required = false,defaultValue = "1")String pageNum){
		PageHelper.startPage(Integer.valueOf(pageNum), Integer.valueOf(pageSize));
		List<ReceptionRecordEntity> list = receptionRecordServiceImpl.selectList();
		PageInfo<ReceptionRecordEntity> pageInfo = new PageInfo<ReceptionRecordEntity>(list); 
		String json = JSONHelper.toJSON(pageInfo);
		System.out.println(json);
		return json;
	}
	
	@RequestMapping(value="/search",produces="application/json; charset=utf-8")
	public @ResponseBody String receptionRecordSearch(
			@RequestParam(value="hotel")String hotel,
			@RequestParam(value="receptionTitle")String receptionTitle,
			@RequestParam(value="receptionDate")String receptionDate,
			@RequestParam(value="pageSize",required = false,defaultValue = "5")String pageSize,
			@RequestParam(value="pageNum",required = false,defaultValue = "1")String pageNum){
		ReceptionRecordEntity reception = new ReceptionRecordEntity();
		reception.setReceptionTitle(receptionTitle);
		reception.setReceptionDate(receptionDate);
		reception.setHotel(hotel);
		PageHelper.startPage(Integer.valueOf(pageNum), Integer.valueOf(pageSize));
		List<ReceptionRecordEntity> list = receptionRecordServiceImpl.selectLike(reception);
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
	
	@RequestMapping(value = "/update", produces = "application/text; charset=utf-8")
	public String updateReceptionRecordInfo(ReceptionRecordEntity reception) {
		String flag = "false";
		int i = receptionRecordServiceImpl.update(reception);
		if (i > 0) {
			flag = "true";
		}
		return flag;
	};
	
	@RequestMapping(value = "/delete")
	public String deleteHotelInfo(@ModelAttribute("receptionRecordEntity") ReceptionRecordEntity reception) {
		String flag = "false";
		int i = receptionRecordServiceImpl.delete(reception);
		if (i > 0) {
			flag = "true";
		}
		return flag;
	};
	
	@RequestMapping(value = "/add", produces = "application/text; charset=utf-8")
	public String addReceptionRecordInfo(@RequestBody ReceptionRecordEntity reception) {
		ReceptionRecordEntity receptionNumber =receptionRecordServiceImpl.getReceptionNumber();
		reception.setReceptionNumber(receptionNumber.getReceptionNumber());
		System.out.println(reception.getReceptionNumber());
		String flag = "false";
		int i = receptionRecordServiceImpl.add(reception);
		if (i > 0) {
			flag = "true";
		}
		return flag;
	};
}
