package com.reception.room.api;

import java.util.List;

import com.reception.room.model.RoomInfoEntity;



public interface RoomService {

	public int addRoomInfo(RoomInfoEntity room);
	
	public int updateRoomInfo(RoomInfoEntity room);
	
	public int deleteRoomInfo(RoomInfoEntity room);
	
	public List<RoomInfoEntity> selectList();
	
	public List<RoomInfoEntity> selectListByHotel(RoomInfoEntity room);
}
