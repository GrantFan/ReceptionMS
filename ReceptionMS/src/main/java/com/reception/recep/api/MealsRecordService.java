package com.reception.recep.api;

import java.util.List;


import com.reception.recep.model.MealsRecordEntity;
import com.reception.recep.model.ReceptionRecordEntity;

public interface MealsRecordService {
	
	int add(MealsRecordEntity meals);
	
	int update(MealsRecordEntity meals);
	
	int delete(MealsRecordEntity meals);
	
	List<MealsRecordEntity> selectList();
	
	List<MealsRecordEntity> selectListBuGuest(String guestName);
	
	List<MealsRecordEntity> selectByReceptionNumber(String receptionNumber);

	MealsRecordEntity selectById(String id);

}
