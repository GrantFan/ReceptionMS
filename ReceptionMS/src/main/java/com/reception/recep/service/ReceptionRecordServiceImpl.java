package com.reception.recep.service;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reception.recep.api.ReceptionRecordService;
import com.reception.recep.dao.ReceptionRecordMapper;
import com.reception.recep.model.AccommodationRecordEntity;
import com.reception.recep.model.MealsRecordEntity;
import com.reception.recep.model.ReceptionRecordEntity;

@Service
public class ReceptionRecordServiceImpl implements ReceptionRecordService {

	@Resource
	ReceptionRecordMapper receptionRecordMapper;
	@Resource
	MealsRecordServiceImpl mealsService;
	@Resource
	AccommodationRecordServiceImpl accomService;

	public ReceptionRecordEntity getReceptionNumber() {
		return receptionRecordMapper.getReceptionNumber();
	};

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int add(ReceptionRecordEntity reception) {
		// TODO Auto-generated method stub
		int k = 0;
		int j = 0;
		int i = receptionRecordMapper.add(reception);
		List<MealsRecordEntity> mealslist = reception.getMeals();
		for (MealsRecordEntity meals : mealslist) {
			meals.setReceptionNumber(reception.getReceptionNumber());
			meals.setId(UUID.randomUUID().toString().replace("-", ""));
			j = mealsService.add(meals);
		}
		List<AccommodationRecordEntity> accomlist = reception.getAccom();
		for (AccommodationRecordEntity accom : accomlist) {
			accom.setReceptionNumber(reception.getReceptionNumber());
			accom.setId(UUID.randomUUID().toString().replace("-", ""));
			k = accomService.add(accom);
		}
		if (i > 0 && j > 0 && k > 0) {
			return 1;
		}
		return 0;
	}

	@Override
	public int update(ReceptionRecordEntity reception) {
		// TODO Auto-generated method stub
		return receptionRecordMapper.update(reception);
	}

	@Override
	public int delete(ReceptionRecordEntity reception) {
		// TODO Auto-generated method stub
		return receptionRecordMapper.delete(reception);
	}

	@Override
	public List<ReceptionRecordEntity> selectList() {
		// TODO Auto-generated method stub
		return receptionRecordMapper.selectList();
	}

	public List<ReceptionRecordEntity> selectByNumber(String receptionNumber) {
		// TODO Auto-generated method stub
		return receptionRecordMapper.selectByNumber(receptionNumber);
	}

	public List<ReceptionRecordEntity> selectLike(ReceptionRecordEntity reception) {
		return receptionRecordMapper.selectLike(reception);
	}
}
