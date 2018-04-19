package com.reception.recep.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.reception.recep.model.MealsRecordEntity;

@Mapper
public interface MealsRecordMapper {
	
	int add(MealsRecordEntity meals);
	
	int update(MealsRecordEntity meals);
	
	int delete(MealsRecordEntity meals);
	
	List<MealsRecordEntity> selectList();
}
