package com.reception.recep.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.reception.recep.model.AccommodationRecordEntity;
import com.reception.recep.model.MealsRecordEntity;

@Mapper
public interface AccommodationRecordMapper {
	
	@Insert("INSERT INTO ACCOMMODATION_RECORD ( ID, reception_number, ROOM_NUMBER, hotel, CHECKIN_TIME,CHECKOUT_TIME, hobby, record_time, remark ) "
			+ "VALUES ( #{id},#{receptionNumber},#{roomNumber},#{hotel},#{checkinTime},#{checkoutTime},#{hobby},sysdate,#{remark} )")
	int add(AccommodationRecordEntity accommodation);
	
	@Update("update accommodation_record set hotel=#{hotel},room_number=#{roomNumber},checkin_time=#{checkinTime},checkout_time=#{checkoutTime},hobby=#{hobby},record_time=sysdate,remark=#{remark} where id= #{id}")
	int update(AccommodationRecordEntity accommodation);
	
	@Delete("delete from accommodation_record where id=#{id}")
	int delete(AccommodationRecordEntity accommodation);
	
	@Select("select id,reception_number receptionNumber,hotel,room_number roomNumber,checkin_time checkinTime,checkout_time checkoutTime,hobby,record_time recordTime,remark from accommodation_record order by record_time desc,reception_number")
	List<AccommodationRecordEntity> selectList();
	
	@Select("select id,reception_number receptionNumber,hotel,room_number roomNumber,checkin_time checkinTime,checkout_time checkoutTime,hobby,record_time recordTime,remark from accommodation_record where reception_number=#{receptionNumber}")
	List<AccommodationRecordEntity> selectByReceptionNumber(String receptionNumber);

	@Delete("delete from accommodation_record where reception_number=#{receptionNumber}")
	int deleteByNumber(String receptionNumber);

	@Select("select id,reception_number receptionNumber,hotel,room_number roomNumber,checkin_time checkinTime,checkout_time checkoutTime,hobby,record_time recordTime,remark from accommodation_record where id=#{id}")
	AccommodationRecordEntity selectById(String id);
}
