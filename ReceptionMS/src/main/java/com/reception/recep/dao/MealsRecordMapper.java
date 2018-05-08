package com.reception.recep.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.reception.recep.model.MealsRecordEntity;

@Mapper
public interface MealsRecordMapper {
	
	int add(MealsRecordEntity meals);
	
	int update(MealsRecordEntity meals);
	
	int delete(MealsRecordEntity meals);
	
	@Select("select id,reception_number receptionNumber,menu_number menuNumber,hotel,meals_time mealsTime,hobby,record_time recordTime,remark from meals_record")
	List<MealsRecordEntity> selectList();
	
	@Select("select id,reception_number receptionNumber,menu_number menuNumber,hotel,meals_time mealsTime,hobby,record_time recordTime,remark from meals_record where reception_number=#{receptionNumber}")
	List<MealsRecordEntity> selectByReceptionNumber(String receptionNumber);
}
