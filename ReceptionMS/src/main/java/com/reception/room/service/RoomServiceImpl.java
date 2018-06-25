package com.reception.room.service;

import java.util.List;
import java.util.Map;

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
		RoomInfoEntity f = null;
		RoomInfoEntity r = null;
		for(int i=0,l=roomFloor.size();i<l;i++){
			f = roomFloor.get(i);
			List<RoomInfoEntity> roomOrientation = roomMapper.selectFloorByOrientation(f);
			f.setList(roomOrientation);
			
			List<RoomInfoEntity> orientation = f.getList();
			for(int j=0,k=orientation.size();j<k;j++){
				r = orientation.get(j);
				List<RoomInfoEntity> rooms = roomMapper.selectListByFloor(r);
				r.setList(rooms);
			}
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
	
	public boolean updatestatusApp(Map<String,String> map) {
		// TODO Auto-generated method stub
		Integer i = roomMapper.updatestatusApp(map);
		return i == 1 ? true : false;
	}
}
