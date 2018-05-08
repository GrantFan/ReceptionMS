package com.reception.recep.api;

import java.util.List;


import com.reception.recep.model.AccommodationRecordEntity;

public interface AccommodationRecordService {
	
	int add(AccommodationRecordEntity accommodation);
	
	int update(AccommodationRecordEntity accommodation);
	
	int delete(AccommodationRecordEntity accommodation);
	
	List<AccommodationRecordEntity> selectList();
	
	List<AccommodationRecordEntity> selectByReceptionNumber(String receptionNumber);
}
