package com.reception.recep.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.reception.recep.api.MealsRecordService;
import com.reception.recep.dao.MealsRecordMapper;
import com.reception.recep.model.MealsRecordEntity;

@Service
public class MealsRecordServiceImpl implements MealsRecordService {

	@Resource
	MealsRecordMapper mealsRecordMapper;
	
	@Override
	public int add(MealsRecordEntity meals) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(MealsRecordEntity meals) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(MealsRecordEntity meals) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MealsRecordEntity> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MealsRecordEntity> selectByReceptionNumber(String receptionNumber) {
		// TODO Auto-generated method stub
		return mealsRecordMapper.selectByReceptionNumber(receptionNumber);
	}

	

}
