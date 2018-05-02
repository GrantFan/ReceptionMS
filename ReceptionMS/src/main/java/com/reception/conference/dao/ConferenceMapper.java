package com.reception.conference.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.TypeHandler;

import com.reception.conference.model.ConferenceEntity;

@Mapper
public interface ConferenceMapper {
	
	@Insert("INSERT INTO conference_info VALUES"
			+ " (#{id}, #{conference_name}, #{hotel}, #{type}, #{position}, #{capacity_num}, #{remark})")
	public void addConferenect(ConferenceEntity conferenceEntity);
	
	@Delete("<script>" 
			+ "DELETE FROM conference_info where id = #{id}" 
			+ "</script>")
	public int delConferenect(String id);
	
	@Update("UPDATE conference_info SET "
			+ "conference_name = #{conference_name}, hotel = #{hotel}, type = #{type}, position = #{position},"
			+ "capacity_num = #{capacity_num}, remark = #{remark}"
			+ "WHERE id = #{id}")
	public int modConferenect(ConferenceEntity conferenceEntity);
	 
	@Select("SELECT * FROM conference_info WHERE id = #{id}")
	public ConferenceEntity queryConferenectById(String id);
	
	@Select("SELECT * FROM conference_info ")
	public List<ConferenceEntity> queryConferenectByPage();
}
