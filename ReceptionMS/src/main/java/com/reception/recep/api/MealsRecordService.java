package com.reception.recep.api;

import java.util.List;


import com.reception.recep.model.MealsRecordEntity;

public interface MealsRecordService {
	
	int add(MealsRecordEntity meals);
	
	int update(MealsRecordEntity meals);
	
	int delete(MealsRecordEntity meals);
	
	List<MealsRecordEntity> selectList();
}
