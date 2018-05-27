package com.reception.recep.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.reception.recep.api.AccommodationRecordService;
import com.reception.recep.dao.AccommodationRecordMapper;
import com.reception.recep.model.AccommodationRecordEntity;
import com.reception.recep.model.ReceptionRecordEntity;

@Service
public class AccommodationRecordServiceImpl implements AccommodationRecordService {
	@Resource
	AccommodationRecordMapper accommodationRecordMapper;
	
	@Resource
	ReceptionRecordServiceImpl receptionService;
	
	@Override
	public int add(AccommodationRecordEntity accommodation) {
		// TODO Auto-generated method stub
		return accommodationRecordMapper.add(accommodation);
	}

	@Override
	public int update(AccommodationRecordEntity accommodation) {
		// TODO Auto-generated method stub
		return accommodationRecordMapper.update(accommodation);
	}

	@Override
	public int delete(AccommodationRecordEntity accommodation) {
		// TODO Auto-generated method stub
		return accommodationRecordMapper.delete(accommodation);
	}

	@Override
	public List<AccommodationRecordEntity> selectList() {
		// TODO Auto-generated method stub
		return accommodationRecordMapper.selectList();
	}

	@Override
	public List<AccommodationRecordEntity> selectByReceptionNumber(String receptionNumber) {
		// TODO Auto-generated method stub
		return accommodationRecordMapper.selectByReceptionNumber(receptionNumber);
	}

	public int deleteByNumber(String receptionNumber) {
		// TODO Auto-generated method stub
		return accommodationRecordMapper.deleteByNumber(receptionNumber);
	}

	@Override
	public AccommodationRecordEntity selectById(String id) {
		// TODO Auto-generated method stub
		return accommodationRecordMapper.selectById(id);
	}

	@Override
	public List<AccommodationRecordEntity> selectByGuestName(String guestName) {
		// TODO Auto-generated method stub
		return accommodationRecordMapper.selectByGuestName(guestName);
	}


}
