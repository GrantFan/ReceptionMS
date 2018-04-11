package com.reception.room.service;

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

}
