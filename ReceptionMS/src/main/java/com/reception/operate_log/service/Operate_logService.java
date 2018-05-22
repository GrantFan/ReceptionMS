package com.reception.operate_log.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reception.operate_log.api.Operate_logApi;
import com.reception.operate_log.dao.Operate_logMapper;
import com.reception.operate_log.entity.Operate_log;

@Service
public class Operate_logService implements Operate_logApi{

	 @Autowired
	 private Operate_logMapper operate_logMapper;
	 
	/**
	 * 插入日志信息
	 */
	@Override
	public int InsertLog(Operate_log operate_log) {
		operate_logMapper.InsertLog(operate_log);
		return operate_logMapper.InsertLog(operate_log);
	}

	/**
	 * 查看日志
	 */
	@Override
	public List<Operate_log> selctLogs(String start,String end) {
		return operate_logMapper.selctLogs(start,end);
	}

}
