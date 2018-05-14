package com.reception.room.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.reception.exceptionfilter.EntityNotFoundException;
import com.reception.hotel.model.HotelInfoEntity;
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
//		System.out.println(json);
		return json;
	};
	
	@RequestMapping(value="/listByHotel",produces="application/text; charset=utf-8")
	public String selectListByHotel(RoomInfoEntity room) {
		List<RoomInfoEntity> list = roomServiceImpl.selectListByHotel(room);
		JSONHelper jsonHelper = new JSONHelper();
		String json = jsonHelper.toJSON(list);
//		System.out.println(json);
		return json;
	};
	
	@RequestMapping(value="/floorList",produces="application/text; charset=utf-8")
	public String selectFloorByHotel(RoomInfoEntity room) {
		List<RoomInfoEntity> list = roomServiceImpl.selectFloorByHotel(room);
		JSONHelper jsonHelper = new JSONHelper();
		String json = jsonHelper.toJSON(list);
//		System.out.println(json);
		return json;
	};
	
	@RequestMapping(value="/floor",produces="application/text; charset=utf-8")
	public String selectFlooRoomrByHotel(RoomInfoEntity room) {
		List<RoomInfoEntity> list = roomServiceImpl.selectFlooRoomrByHotel(room);
		JSONHelper jsonHelper = new JSONHelper();
		String json = jsonHelper.toJSON(list);
//		System.out.println(json);
		return json;
	};
	
	@RequestMapping(value="/roomType",produces="application/text; charset=utf-8")
	public String selectByRoomType(String hotel_l,String hotel_r,String  roomType) {
		RoomInfoEntity room1 = new RoomInfoEntity();
		room1.setHotel(hotel_l);
		room1.setRoomType(roomType);
		List<RoomInfoEntity> list1 = roomServiceImpl.selectByRoomType(room1);
		
		RoomInfoEntity room2 = new RoomInfoEntity();
		room2.setHotel(hotel_r);
		room2.setRoomType(roomType);
		List<RoomInfoEntity> list2 = roomServiceImpl.selectByRoomType(room2);
		
		Map map = new HashMap<String, List>();
		map.put("hotel_l", list1);
		map.put("hotel_r", list2);
		String json = JSONHelper.toJSON(map);
//		System.out.println(json);
		return json;
	};
	
	@RequestMapping(value = "{id}",method = RequestMethod.GET)
	public String queryRoomById(@PathVariable("id")String id){
		RoomInfoEntity room =  this.roomServiceImpl.selectById(id);  
		if(room == null){
			new EntityNotFoundException("不存在"); 
		}
		return JSONHelper.toJSON(room);
	}
}
