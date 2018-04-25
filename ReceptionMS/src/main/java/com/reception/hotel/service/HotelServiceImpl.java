package com.reception.hotel.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.reception.hotel.api.HotelService;
import com.reception.hotel.dao.HotelMapper;
import com.reception.hotel.model.HotelInfoEntity;

@Service
public class HotelServiceImpl implements HotelService {

	@Resource
	HotelMapper hotelMapper;
	
	@Override
	public int addHotelInfo(HotelInfoEntity hotel) {
		// TODO Auto-generated method stub
		return hotelMapper.addHotelInfo(hotel);
	}

	@Override
	public int updateHotelInfo(HotelInfoEntity hotel) {
		// TODO Auto-generated method stub
		return hotelMapper.updateHotelInfo(hotel);
	}

	@Override
	public int deleteHotelInfo(HotelInfoEntity hotel) {
		// TODO Auto-generated method stub
		return hotelMapper.deleteHotelInfo(hotel);
	}

	@Override
	public List<HotelInfoEntity> selectList() {
		// TODO Auto-generated method stub
		return hotelMapper.selectList();
	}

	@Override
	public List<HotelInfoEntity> selectListByName(HotelInfoEntity hotel) {
		// TODO Auto-generated method stub
		return hotelMapper.selectListByName(hotel);
	}

}
