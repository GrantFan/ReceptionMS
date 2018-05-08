package com.reception.recep.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.reception.recep.model.AccommodationRecordEntity;
import com.reception.recep.model.MealsRecordEntity;

@Mapper
public interface AccommodationRecordMapper {
	
	int add(AccommodationRecordEntity accommodation);
	
	int update(AccommodationRecordEntity accommodation);
	
	int delete(AccommodationRecordEntity accommodation);
	
	@Select("select id,reception_number receptionNumber,hotel,room_number roomNumber,checkin_time checkinTime,checkout_time checkoutTime,hobby,record_time recordTime,remark from accommodation_record")
	List<AccommodationRecordEntity> selectList();
	
	@Select("select id,reception_number receptionNumber,hotel,room_number roomNumber,checkin_time checkinTime,checkout_time checkoutTime,hobby,record_time recordTime,remark from accommodation_record where reception_number=#{receptionNumber}")
	List<AccommodationRecordEntity> selectByReceptionNumber(String receptionNumber);
}
