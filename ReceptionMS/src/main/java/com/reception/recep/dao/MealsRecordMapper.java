package com.reception.recep.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.reception.recep.model.MealsRecordEntity;

@Mapper
public interface MealsRecordMapper {
	
	@Insert("INSERT INTO MEALS_RECORD ( ID, reception_number, menu_number, hotel, meals_time, hobby, record_time, remark ) "
			+ "VALUES ( #{id},#{receptionNumber},#{menuNumber},#{hotel},#{mealsTime},#{hobby},sysdate,#{remark} )")
	int add(MealsRecordEntity meals);
	
	@Update("update meals_record set hotel=#{hotel},menu_number=#{menuNumber},meals_time=#{mealsTime},hobby=#{hobby},record_time=sysdate,remark=#{remark} where id= #{id}")
	int update(MealsRecordEntity meals);
	
	@Delete("delete from meals_record where id=#{id}")
	int delete(MealsRecordEntity meals);
	
	@Select("select id,reception_number receptionNumber,menu_number menuNumber,hotel,meals_time mealsTime,hobby,record_time recordTime,remark from meals_record")
	List<MealsRecordEntity> selectList();
	
	@Select("select id,reception_number receptionNumber,menu_number menuNumber,hotel,meals_time mealsTime,hobby,record_time recordTime,remark from meals_record where reception_number=#{receptionNumber}")
	List<MealsRecordEntity> selectByReceptionNumber(String receptionNumber);

	@Delete("delete from meals_record where reception_number=#{receptionNumber}")
	int deleteByNumber(String receptionNumber);
}
