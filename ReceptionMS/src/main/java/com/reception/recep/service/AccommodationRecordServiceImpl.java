package com.reception.recep.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.reception.recep.api.AccommodationRecordService;
import com.reception.recep.dao.AccommodationRecordMapper;
import com.reception.recep.model.AccommodationRecordEntity;

@Service
public class AccommodationRecordServiceImpl implements AccommodationRecordService {
	@Resource
	AccommodationRecordMapper accommodationRecordMapper;
	
	@Override
	public int add(AccommodationRecordEntity accommodation) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(AccommodationRecordEntity accommodation) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(AccommodationRecordEntity accommodation) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AccommodationRecordEntity> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccommodationRecordEntity> selectByReceptionNumber(String receptionNumber) {
		// TODO Auto-generated method stub
		return accommodationRecordMapper.selectByReceptionNumber(receptionNumber);
	}


}
