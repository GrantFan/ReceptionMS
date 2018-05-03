package com.reception.room.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.reception.room.model.RoomInfoEntity;
import com.reception.room.service.RoomServiceImpl;
import com.reception.util.JSONHelper;

@RestController
@RequestMapping(value = "/room")
public class RoomAction {

	@Resource
	RoomServiceImpl roomServiceImpl;

	@RequestMapping(value="/add",produces="application/text; charset=utf-8")
	public @ResponseBody String addHotelInfo(RoomInfoEntity room) {
		String flag = "false";
		int i = roomServiceImpl.addRoomInfo(room);
		if(i>0){
			flag = "true";
		}
		return flag;
	};

	@RequestMapping(value="/update",produces="application/text; charset=utf-8")
	public String updateHotelInfo(RoomInfoEntity room) {
		String flag = "false";
		int i = roomServiceImpl.updateRoomInfo(room);
		if (i > 0) {
			flag = "true";
		}
		return flag;
	};

	@RequestMapping(value="/delete",produces="application/text; charset=utf-8")
	public String deleteHotelInfo(RoomInfoEntity room) {
		String flag = "false";
		int i = roomServiceImpl.deleteRoomInfo(room);
		if (i > 0) {
			flag = "true";
		}
		return flag;
	};

	@RequestMapping(value="/list",produces="application/text; charset=utf-8")
	public String selectList() {
		List<RoomInfoEntity> list = roomServiceImpl.selectList();
		JSONHelper jsonHelper = new JSONHelper();
		String json = jsonHelper.toJSON(list);
		System.out.println(json);
		return json;
	};
	
	@RequestMapping(value="/listByHotel",produces="application/text; charset=utf-8")
	public String selectListByHotel(RoomInfoEntity room) {
		List<RoomInfoEntity> list = roomServiceImpl.selectListByHotel(room);
		JSONHelper jsonHelper = new JSONHelper();
		String json = jsonHelper.toJSON(list);
		System.out.println(json);
		return json;
	};
	
	@RequestMapping(value="/floor",produces="application/text; charset=utf-8")
	public String selectFloorByHotel(RoomInfoEntity room) {
		List<RoomInfoEntity> list = roomServiceImpl.selectFloorByHotel(room);
		JSONHelper jsonHelper = new JSONHelper();
		String json = jsonHelper.toJSON(list);
		System.out.println(json);
		return json;
	};
}
