package com.reception.recep.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reception.recep.api.MealsRecordService;
import com.reception.recep.model.MealsRecordEntity;

@RestController
@RequestMapping(value="/meals")
public class MealsRecordAction {
	@Resource
	MealsRecordService mealsRecordService;
	
	@RequestMapping(value = "/update", produces = "application/text; charset=utf-8")
	public String updateReceptionRecordInfo(MealsRecordEntity meals) {
		String flag = "false";
		int i = mealsRecordService.update(meals);
		if (i > 0) {
			flag = "true";
		}
		return flag;
	};
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public String deleteHotelInfo(@ModelAttribute("mealsRecordEntity") MealsRecordEntity meals) {
		String flag = "false";
		int i = mealsRecordService.delete(meals);
		if (i > 0) {
			flag = "true";
		}
		return flag;
	};
}
