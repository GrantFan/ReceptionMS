package com.reception.recep.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.reception.recep.model.ReceptionRecordEntity;

@Mapper
public interface ReceptionRecordMapper {
	
	int add(ReceptionRecordEntity reception);
	
	int update(ReceptionRecordEntity reception);
	
	int delete(ReceptionRecordEntity reception);
	
	List<ReceptionRecordEntity> selectList();
}
