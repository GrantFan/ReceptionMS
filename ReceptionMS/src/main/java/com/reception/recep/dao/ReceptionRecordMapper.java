package com.reception.recep.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.reception.recep.model.ReceptionRecordEntity;

@Mapper
public interface ReceptionRecordMapper {
	
	@Select("select 'JD'||TO_CHAR(sysdate,'YYYYMMDDHHmmSS') receptionNumber from dual")
	ReceptionRecordEntity getReceptionNumber();
	
	@Insert("insert into reception_record( id, reception_number, reception_title, reception_date, reception_person, reception_printer, guest_name, entourage, guest_num, reception_num, reception_days, hotel, description, record_time, remark) "
			+ "VALUES((select nvl(max(id),0)+1 from reception_record),#{receptionNumber},#{receptionTitle},#{receptionDate},#{receptionPerson},#{receptionPrinter},#{guestName},#{entourage},#{guestNum},#{receptionNum},#{receptionDays},#{hotel},#{description},sysdate,#{remark})")
	int add(ReceptionRecordEntity reception);
	
	@Update({"<script>",
				"update reception_record set ",
				"reception_title=#{receptionTitle},",
				"reception_date=#{receptionDate},",
				"reception_person=#{receptionPerson},",
				"reception_printer=#{receptionPrinter},",
				"guest_name=#{guestName},",
				"entourage=#{entourage},",
				"guest_num=#{guestNum},",
				"reception_num=#{receptionNum},",
				"reception_days=#{receptionDays},",
				"hotel=#{hotel},",
				"description=#{description},",
				"remark=#{remark}",
				"where reception_number=#{receptionNumber}",
				"</script>"})
	int update(ReceptionRecordEntity reception);
	
	@Delete("delete from reception_record where reception_number=#{receptionNumber}")
	int delete(ReceptionRecordEntity reception);
	
	@Select("select id,reception_number receptionNumber,reception_title receptionTitle,reception_date receptionDate,reception_person receptionPerson,reception_printer receptionPrinter,guest_name guestName,entourage,guest_num guestNum,reception_num receptionNum,reception_days receptionDays,hotel,description,record_time recordTime,remark from reception_record order by record_time desc")
	List<ReceptionRecordEntity> selectList();
	
	@Select("select id,reception_number receptionNumber,reception_title receptionTitle,reception_date receptionDate,reception_person receptionPerson,reception_printer receptionPrinter,guest_name guestName,entourage,guest_num guestNum,reception_num receptionNum,reception_days receptionDays,hotel,description,record_time recordTime,remark from reception_record where reception_number=#{receptionNumber}")
	ReceptionRecordEntity selectByNumber(String receptionNumber);

	@Select({"<script>",
			"select id,reception_number receptionNumber,reception_title receptionTitle,reception_date receptionDate,reception_person receptionPerson,reception_printer receptionPrinter,guest_name guestName,entourage,guest_num guestNum,reception_num receptionNum,reception_days receptionDays,hotel,description,record_time recordTime,remark from reception_record ",
			"where 1=1 ",
			"<if test=\" ''!= guestName and null != guestName \">",
			"and guest_name like concat(#{guestName},'%')",
			"</if>",
			"<if test=\" ''!= hotel and null != hotel\">",
			"and hotel = #{hotel}",
			"</if>",
			"<if test=\" ''!= receptionDate and null != receptionDate\">",
			"and reception_date=#{receptionDate}",
			"</if>",
			"</script>"})
	List<ReceptionRecordEntity> selectLike(ReceptionRecordEntity reception);
}
