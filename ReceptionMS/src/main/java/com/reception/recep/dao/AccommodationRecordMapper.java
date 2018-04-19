package com.reception.recep.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.reception.recep.model.AccommodationRecordEntity;

@Mapper
public interface AccommodationRecordMapper {
	
	int add(AccommodationRecordEntity accommodation);
	
	int update(AccommodationRecordEntity accommodation);
	
	int delete(AccommodationRecordEntity accommodation);
	
	List<AccommodationRecordEntity> selectList();
}
