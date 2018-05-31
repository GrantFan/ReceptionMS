package com.reception.room.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.reception.room.api.RoomService;
import com.reception.room.dao.RoomMapper;
import com.reception.room.model.RoomInfoEntity;

@Service
public class RoomServiceImpl implements RoomService {

	@Resource
	RoomMapper roomMapper;
	
	@Override
	public int addRoomInfo(RoomInfoEntity room) {
		// TODO Auto-generated method stub
		return roomMapper.addRoomInfo(room);
	}
	
    @Override
	public int updateRoomInfo(RoomInfoEntity room) {
		// TODO Auto-generated method stub
		return roomMapper.updateRoomInfo(room);
	}

	@Override
	public int deleteRoomInfo(RoomInfoEntity room) {
		// TODO Auto-generated method stub
		return roomMapper.deleteRoomInfo(room);
	}

	@Override
	public List<RoomInfoEntity> selectList() {
		// TODO Auto-generated method stub
		return roomMapper.selectList();
	}
	@Override
	public List<RoomInfoEntity> selectListByHotel(RoomInfoEntity room){
		List<RoomInfoEntity> roomFloor =  roomMapper.selectFloorByHotel(room);
		for(int i=0,l=roomFloor.size();i<l;i++){
			RoomInfoEntity r = roomFloor.get(i);
			List<RoomInfoEntity> rooms = roomMapper.selectListByHotel(r);
			r.setList(rooms);
		}
		return roomFloor;
	}
	
	public List<RoomInfoEntity> selectFloorByHotel(RoomInfoEntity room){
		return roomMapper.selectFloorByHotel(room);
	}

	public List<RoomInfoEntity> selectFlooRoomrByHotel(RoomInfoEntity room) {
		// TODO Auto-generated method stub
		return roomMapper.selectListByHotel(room);
	}
	
	public List<RoomInfoEntity> selectByRoomType(RoomInfoEntity room){
		return roomMapper.selectByRoomType(room);
	}

	public RoomInfoEntity selectById(String id) {
		// TODO Auto-generated method stub
		return roomMapper.selectById(id);
	}

	public List<RoomInfoEntity> selectListByHotelApp(RoomInfoEntity room) {
		// TODO Auto-generated method stub
		return roomMapper.selectListByHotelApp(room);
	}
}
