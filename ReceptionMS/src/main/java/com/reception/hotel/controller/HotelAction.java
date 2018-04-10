package com.reception.hotel.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reception.hotel.model.HotelInfoEntity;
import com.reception.hotel.service.HotelServiceImpl;
import com.reception.util.JSONHelper;

@Controller
public class HotelAction {

	@Resource
	HotelServiceImpl hotelServiceImpl;
	@RequestMapping
	public String addHotelInfo(HotelInfoEntity hotel) {
		hotelServiceImpl.addHotelInfo(hotel);
		
		return "";
	};

	public String updateHotelInfo(HotelInfoEntity hotel) {
		return "";
	};

	public String deleteHotelInfo(HotelInfoEntity hotel) {
		return "";
	};

	public String selectList() {
		List<HotelInfoEntity> list = hotelServiceImpl.selectList();
		JSONHelper json = new JSONHelper();
		
		return json.toJSON(list);
	};
}
