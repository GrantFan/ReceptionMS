package com.reception.operate_log.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.reception.dictionary.api.DictionaryTableService;
import com.reception.guest.entity.Guest_Info;
import com.reception.guest.service.Guest_InfoService;
import com.reception.operate_log.entity.Operate_log;
import com.reception.operate_log.service.Operate_logService;
import com.reception.util.JSONHelper;

@RestController
@RequestMapping("/log")
public class Operate_logAction {
	
	   @Autowired
	   private Operate_logService operate_logservice;
	    


	    /**
	     * 添加宾客信息
	     * @param guest_info
	     * @return
	     */
	    @RequestMapping(value = "/select",method = RequestMethod.GET)
	    public String selectLog(@RequestParam(value="pageNum")String pageNum,@RequestParam(value="pageSize")String pageSize,@RequestParam("start") String start,@RequestParam("end") String end){
	    	PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
	      	List<Operate_log> operate_logs = operate_logservice.selctLogs(start,end);
	      	PageInfo<Operate_log> pageInfo = new PageInfo<Operate_log>(operate_logs);
	          return JSONHelper.toJSON(pageInfo);
	    }


}
