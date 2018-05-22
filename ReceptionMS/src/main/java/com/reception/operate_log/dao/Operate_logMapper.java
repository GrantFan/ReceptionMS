package com.reception.operate_log.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.reception.operate_log.entity.Operate_log;

@Mapper
public interface Operate_logMapper {

	 /**
     * 插入日志
     * @param operate_log
     * @return
     */
    @Insert("insert into sys_operation_log(id,operator,module,time,compuer_ip,compuer_name,remark)"
			+ "values((select nvl(max(id),0)+1 from sys_operation_log),#{operator},#{module},#{time},#{compuer_ip},#{compuer_name},#{remark})")
    int InsertLog(Operate_log operate_log);
    
    /**
     * 插入日志
     * @param operate_log
     * @return
     */
   // @Select("select * from sys_operation_log order by time desc")
    @Select("select * from sys_operation_log where substr(time,0,10) >= #{start} and substr(time,0,10) <=#{end} order  by time desc")
    List<Operate_log> selctLogs(@Param("start") String start,@Param("end") String end);
}

