package com.reception.operate_log.api;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.reception.operate_log.entity.Operate_log;

public interface Operate_logApi {
	
	/**
	 * 插入日志
	 * @param operate_log
	 * @return
	 */
	 int InsertLog(Operate_log operate_log);
	 
	 /**
	  * 查看日志
	  * @param operate_log
	  * @return
	  */
	 List<Operate_log> selctLogs(String start,String end);
}
