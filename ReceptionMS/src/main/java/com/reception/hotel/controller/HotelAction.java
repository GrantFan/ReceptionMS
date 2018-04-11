package com.reception.hotel.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.reception.hotel.model.HotelInfoEntity;
import com.reception.hotel.service.HotelServiceImpl;
import com.reception.util.JSONHelper;

@RestController
@RequestMapping(value = "/hotel")
public class HotelAction {

	@Resource
	HotelServiceImpl hotelServiceImpl;

	@RequestMapping(value="/add",produces="application/text; charset=utf-8")
	public @ResponseBody String addHotelInfo(HotelInfoEntity hotel) {
		String flag = "false";
		int i = hotelServiceImpl.addHotelInfo(hotel);
		if(i>0){
			flag = "true";
		}
		return flag;
	};

	@RequestMapping(value="/update",produces="application/text; charset=utf-8")
	public String updateHotelInfo(HotelInfoEntity hotel) {
		String flag = "false";
		int i = hotelServiceImpl.updateHotelInfo(hotel);
		if (i > 0) {
			flag = "true";
		}
		return flag;
	};

	@RequestMapping(value="/delete",produces="application/text; charset=utf-8")
	public String deleteHotelInfo(HotelInfoEntity hotel) {
		String flag = "false";
		int i = hotelServiceImpl.deleteHotelInfo(hotel);
		if (i > 0) {
			flag = "true";
		}
		return flag;
	};

	@RequestMapping(value="/list",produces="application/text; charset=utf-8")
	public String selectList() {
		List<HotelInfoEntity> list = hotelServiceImpl.selectList();
		JSONHelper jsonHelper = new JSONHelper();
		String json = jsonHelper.toJSON(list);
		System.out.println(json);
		return json;
	};
}
