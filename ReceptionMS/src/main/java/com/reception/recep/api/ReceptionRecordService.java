package com.reception.recep.api;

import java.util.List;


import com.reception.recep.model.ReceptionRecordEntity;

public interface ReceptionRecordService {
	
	int add(ReceptionRecordEntity reception);
	
	int update(ReceptionRecordEntity reception);
	
	int delete(ReceptionRecordEntity reception);
	
	List<ReceptionRecordEntity> selectList();
}
