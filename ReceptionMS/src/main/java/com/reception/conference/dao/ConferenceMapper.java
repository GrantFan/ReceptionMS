package com.reception.conference.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.reception.conference.model.ConferenceEntity;

@Mapper
public interface ConferenceMapper {
	
	@Insert("INSERT INTO conference_info VALUES"
			+ " (#{id}, #{conference_name}, #{hotel}, #{type}, #{position}, #{capacity_num}, #{remark})")
	public void addConferenect(ConferenceEntity conferenceEntity);
	
	@Delete("<script>" 
			+ "DELETE FROM conference_info" 
			+ " where id in "
			+ "<foreach collection=\"array\" item=\"id\"   "
            + " open=\"(\" close=\")\" separator=\",\"> "  
            + " #{id} " 
            + " </foreach>  "  
			+ "</script>")
	public int delConferenect(String[] id);
	
	@Update("UPDATE conference_info SET "
			+ "conference_name = #{conference_name}, hotel = #{hotel}, type = #{type}, position = #{position},"
			+ "capacity_num = #{capacity_num}, remark = #{remark}"
			+ "WHERE id = #{id}")
	public int modConferenect(ConferenceEntity conferenceEntity);
	 
	@Select("SELECT * FROM conference_info WHERE id = #{id}")
	public ConferenceEntity queryConferenectById(String id);
	
	@Select("<script>"
			+ "SELECT * FROM conference_info "
			+ "WHERE 1 = 1 "
			+ " <if test=\" '' != hotel  and null != hotel\"> "
			+ " and hotel = #{hotel,jdbcType=VARCHAR} "
			+ " </if>"
			+ " <if test=\" '' != boardType  and null != boardType\"> "
			+ " and type = #{boardType,jdbcType=VARCHAR} "
			+ " </if>"
			+ "</script>")
	public List<ConferenceEntity> queryConferenectByPage(Map map);
	
	@Select("SELECT con.id,con.conference_name FROM conference_info con where con.hotel = #{hotel_name} ")
	public List<ConferenceEntity> queryConferenectList(String hotel_name);
	
}
