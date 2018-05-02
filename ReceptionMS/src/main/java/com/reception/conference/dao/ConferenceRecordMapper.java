package com.reception.conference.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.reception.conference.model.ConferenceRecordEntity;


@Mapper
public interface ConferenceRecordMapper {
	
	@Insert("INSERT INTO conference_record VALUES"
			+ " (#{id}, #{use_number}, #{conference_name}, #{hotel}, #{use_date}, #{start_time}, #{end_time}, #{purpose}, #{guest_num}, #{remark});")
	public void addConferenectRecord(ConferenceRecordEntity conferenceRecordEntity);
	
	@Delete("DELETE FROM conference_record where id = #{id}")
	public int delConferenectRecord(String id);
	
	@Update("UPDATE conference_record SET "
			+ "conference_name = #{conference_name}, hotel = #{hotel}, type = #{type}, position = #{position},"
			+ "capacity_num = #{capacity_num}, remark = #{remark}"
			+ "WHERE id = #{id}")
	public int modConferenectRecord(Integer id);

	@Select("SELECT id,conference_name,hotel,type,position,capacity_num,nvl(remark，'') FROM conference_record WHERE id = #{id}")
	public ConferenceRecordEntity queryConferenecRecordtById(Integer id);
	
	@Select("SELECT id,conference_name,hotel,type,position,capacity_num,nvl(remark，'') FROM conference_record ")
	public List<ConferenceRecordEntity> queryConferenectRecordByPage();
	
}
