package com.reception.conference.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.reception.conference.model.ConferenceRecordEntity;
import com.reception.conference.model.HotelUtil;


@Mapper
public interface ConferenceRecordMapper {
	
	@Insert("INSERT INTO conference_record "
			+ "(ID,USE_NUMBER,CONFERENCE_NAME,HOTEL,USE_DATE,START_TIME,END_TIME,PURPOSE,GUEST_NUM,REMARK,CREATEDATE,UPDATEDATE)"
			+ " VALUES"
			+ " (#{Id}, #{Use_number}, #{Conference_name}, #{Hotel}, to_date(#{Use_date},'yyyy-mm-dd'), #{Start_time}, #{End_time},"
			+ " #{Purpose}, #{Guest_num}, #{Remark},SYSDATE,SYSDATE)")
	public void addConferenectRecord(ConferenceRecordEntity conferenceRecordEntity);
	
	@Delete("DELETE FROM conference_record where id = #{id}")
	public int delConferenectRecord(String id);
	
	@Update("UPDATE conference_record SET "
			+ "CONFERENCE_NAME = #{Conference_name}, HOTEL = #{Hotel}, USE_DATE = to_date(#{Use_date},'yyyy-mm-dd'), START_TIME = #{Start_time},END_TIME = #{End_time},"
			+ "PURPOSE = #{Purpose}, GUEST_NUM = #{Guest_num}, REMARK = #{Remark},UPDATEDATE = SYSDATE "
			+ "WHERE id = #{Id}")
	public int modConferenectRecord(ConferenceRecordEntity conferenceRecordEntity);

	@Select("SELECT id, USE_NUMBER,  CONFERENCE_NAME,  HOTEL,  to_char(USE_DATE,'yyyy-mm-dd') USE_DATE,START_TIME,END_TIME, PURPOSE, "
			+ "GUEST_NUM, nvl(REMARK， '')  FROM conference_record WHERE id = #{id}")
	public ConferenceRecordEntity queryConferenceRecordById(String id);
	                              
	@Select("<script>"
			+ " SELECT record.id,record.USE_NUMBER,record.CONFERENCE_NAME,record.HOTEL,to_char(record.USE_DATE, 'yyyy-mm-dd') USE_DATE,"
			+ " record.START_TIME,record.END_TIME,record.PURPOSE,record.GUEST_NUM,nvl(record.REMARK， '') "
			+ " FROM CONFERENCE_RECORD record    "
			+ " WHERE 1 = 1 "
			+ " <if test=\" '' != hotelName  and null != hotelName\"> "
			+ " and HOTEL_NAME = #{hotelName} "
			+ "</if>"
			+ " <if test=\" '' != CONFERENCE_TYPE  and null != CONFERENCE_TYPE\"> "
			+ " and CONFERENCE_TYPE = #{CONFERENCE_TYPE} "
			+ "</if>" 
			+ " ORDER BY record.USE_NUMBER"
			+ "</script>") 
	public List<ConferenceRecordEntity> queryConferenectRecordByPage(Map map);
	
//	@Select("<script>"
//			+ " SELECT HOTEL_NAME NAME, HOTEL.ID ID  "
//			+ " FROM CONFERENCE_RECORD RECORD    "
//			+ " LEFT JOIN HOTEL_INFO HOTEL       "
//			+ " ON RECORD.HOTEL = HOTEL.HOTEL_NAME "
//			+ " WHERE to_date(#{date}, 'yyyy-mm-dd HH24:mi:ss') &lt; "
//		    + "  to_date(to_char(RECORD.use_date, 'yyyy-mm-dd') || ' ' || "
//		    + "  RECORD.End_Time, "
//		    + "   'yyyy-mm-dd HH24:mi:ss')  "
//			+ " <if test=\" '' != HOTEL_NAME  and null != HOTEL_NAME\"> "
//			+ " and HOTEL_NAME = #{hotelName}) "
//			+ "</if>"
//			+ " <if test=\" '' != CONFERENCE_TYPE  and null != CONFERENCE_TYPE\"> "
//			+ " and CONFERENCE_TYPE = #{CONFERENCE_TYPE}) "
//			+ "</if>"
//			+ " GROUP BY HOTEL_NAME, HOTEL.ID " 
//			+ " ORDER BY HOTEL.ID    "
//			+ "</script>") 
	@Select("<script>"
			+ " SELECT HOTEL_NAME NAME, HOTEL.ID ID  "
			+ " FROM CONFERENCE_RECORD RECORD    "
			+ " LEFT JOIN HOTEL_INFO HOTEL       "
			+ " ON RECORD.HOTEL = HOTEL.HOTEL_NAME "
			+ " WHERE 1 = 1 "
			+ " <if test=\" '' != hotelName  and null != hotelName\"> "
			+ " and HOTEL_NAME = #{hotelName} "
			+ "</if>"
//			+ " <if test=\" '' != CONFERENCE_TYPE  and null != CONFERENCE_TYPE\"> "
//			+ " and CONFERENCE_TYPE = #{CONFERENCE_TYPE} "
//			+ "</if>"
			+ " GROUP BY HOTEL_NAME, HOTEL.ID " 
			+ " ORDER BY HOTEL.ID    "
			+ "</script>") 
	public List<HotelUtil> hotelList(Map map);
	
	@Select("<script>"
			+ "  SELECT record.id,record.USE_NUMBER,info.CONFERENCE_NAME,info.HOTEL,to_char(record.USE_DATE, 'yyyy-mm-dd') USE_DATE,"
			+ "  record.START_TIME,record.END_TIME,record.PURPOSE,record.GUEST_NUM,nvl(record.REMARK， '')  ,"
			+ "  CONCAT(CONCAT(to_char(USE_DATE, 'yyyy-mm-dd'), ' '),to_char(to_date(record.START_Time,'HH24:mi:ss'),'HH24:mi:ss')) as START_DATE, " 
			+ "  CONCAT(CONCAT(to_char(USE_DATE, 'yyyy-mm-dd'), ' '), to_char(to_date(record.END_Time,'HH24:mi:ss'),'HH24:mi:ss')) as END_DATE "
			+ "  FROM conference_info info"
			+ "   left join (select * from conference_record t "
			+ "   where to_date(#{nowtime,jdbcType=VARCHAR},'yyyy-mm-dd HH24:mi:ss') &lt; to_date(to_char(t.use_date, 'yyyy-mm-dd')||' '||t.End_Time,'yyyy-mm-dd HH24:mi:ss') "
			+ "   and #{date,jdbcType=VARCHAR} = to_char(use_date,'yyyy-mm-dd')) record"
			+ "  on info.conference_name = record.conference_name"
			+ "  WHERE info.hotel = #{name,jdbcType=VARCHAR} "
			+ " <if test=\" '' != CONFERENCE_TYPE  and null != CONFERENCE_TYPE\"> "
			+ " and type = #{CONFERENCE_TYPE} "
			+ "</if>"
			+ "  ORDER BY info.CONFERENCE_NAME " 
		    + "</script>") 
	public List<ConferenceRecordEntity> queryConferenecByHotelName(Map map); 
	
	@Select("SELECT COUNT(1)+1 FROM conference_record record WHERE to_char(record.createdate, 'yyyymmdd') = #{now_date} ")
	public Integer getUse_Number(String now_date); 
	
	@Select("SELECT  CONCAT(CONCAT(to_char(USE_DATE, 'yyyy-mm-dd'), ' '),to_char(to_date(record.START_Time,'HH24:mi:ss'),'HH24:mi:ss')) as START_DATE, "
			+ " CONCAT(CONCAT(to_char(USE_DATE, 'yyyy-mm-dd'), ' '), to_char(to_date(record.END_Time,'HH24:mi:ss'),'HH24:mi:ss')) as END_DATE"
			+ " FROM conference_record record WHERE HOTEL = #{Hotel} and CONFERENCE_NAME = #{Conference_name} and USE_DATE = to_date(#{Use_date},'yyyy-mm-dd') ")
	public List<ConferenceRecordEntity> checkConferenceRecord(ConferenceRecordEntity conferenceRecordEntity);  
}
