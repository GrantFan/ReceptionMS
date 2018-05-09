package com.reception.recep.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reception.recep.api.AccommodationRecordService;
import com.reception.recep.model.AccommodationRecordEntity;
import com.reception.recep.model.MealsRecordEntity;

@RestController
@RequestMapping(value="/accom")
public class AccommodationRecordAction {
	@Resource
	AccommodationRecordService accommodationRecordService;
	
	@RequestMapping(value = "/update", produces = "application/text; charset=utf-8")
	public String updateReceptionRecordInfo(AccommodationRecordEntity accommodation) {
		String flag = "false";
		int i = accommodationRecordService.update(accommodation);
		if (i > 0) {
			flag = "true";
		}
		return flag;
	};
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public String deleteHotelInfo(@ModelAttribute("accommodationRecordEntity") AccommodationRecordEntity accommodation) {
		String flag = "false";
		int i = accommodationRecordService.delete(accommodation);
		if (i > 0) {
			flag = "true";
		}
		return flag;
	};
}
