package com.reception.recep.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.reception.recep.model.ReceptionRecordEntity;
import com.reception.recep.service.ReceptionRecordServiceImpl;
import com.reception.util.JSONHelper;

@RestController
@RequestMapping(value="/recep")
public class ReceptionRecordAction {

	@Resource
	ReceptionRecordServiceImpl receptionRecordServiceImpl;
	
	@RequestMapping(value="/list",produces="application/text; charset=utf-8")
	public @ResponseBody String receptionRecordList(@RequestParam(value="pageSize")String pageSize,@RequestParam(value="pageNum")String pageNum){
		long total = PageHelper.count(() -> {receptionRecordServiceImpl.selectList();});
		PageHelper.startPage(Integer.valueOf(pageNum), Integer.valueOf(pageSize));
		Page page = PageHelper.getLocalPage();
    	long totalPage = total / page.getPageSize() + ((total % page.getPageSize() == 0) ? 0 : 1);//总页数
		
		List<ReceptionRecordEntity> list = receptionRecordServiceImpl.selectList();
		JSONHelper jsonHelper = new JSONHelper();
		String json = jsonHelper.toJSON(list);
		System.out.println(json);
		return json;
	}
}
