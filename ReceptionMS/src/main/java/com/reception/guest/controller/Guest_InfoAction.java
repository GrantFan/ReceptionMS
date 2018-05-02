package com.reception.guest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.reception.guest.entity.Guest_Info;
import com.reception.guest.service.Guest_InfoService;
import com.reception.util.JSONHelper;

/**
 * @author zhangwei
 * @description  宾客信息管理
 * @date created in 16:41 2018/4/13
 * @throws Exception
 */
@RestController
@RequestMapping("/guest")
public class Guest_InfoAction {

    private static final Logger log = LoggerFactory.getLogger(Guest_InfoAction.class);

    @Autowired
    private Guest_InfoService guest_infoService;

    /**
     * 添加宾客信息
     * @param guest_info
     * @return
     */
    @RequestMapping(value = "/insert" , method =  RequestMethod.POST)
    public @ResponseBody int InsertGuest_Info(Guest_Info guest_info,HttpServletRequest request){
    	System.out.println(guest_info);
        return guest_infoService.InsertGuest_Info(guest_info);
    }

    /**
     * 更新宾客信息
     * @param guest_info
     * @return
     */
    @RequestMapping(value = "/update" , method =  RequestMethod.POST)
    public @ResponseBody int UpdateGuest_Info(Guest_Info guest_info,HttpServletRequest request){
        return guest_infoService.UpdateGuest_Info(guest_info);
    }

    /**
     * 删除宾客信息
     * @param guest_name
     * @return
     */
    @RequestMapping(value = "/delete" , method =  RequestMethod.DELETE)
    public int DeleteGuest_Info(@RequestParam("id") int id){
        return guest_infoService.DeleteGuest_Info(id);
    }

    /**
     * 分页查询数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/select", method =  RequestMethod.GET)
    public String SeleteGuest_Info(@RequestParam(value="pageNum")String pageNum,@RequestParam(value="pageSize")String pageSize){
        PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
    	List<Guest_Info> guest_infos = guest_infoService.SelectGuest_Info();
    	PageInfo<Guest_Info> pageInfo = new PageInfo<Guest_Info>(guest_infos);
        return JSONHelper.toJSON(pageInfo);
    }

    /**
     * 根据宾客的id，查看宾客的详细信息
     * @param id
     * @return
     */
    @RequestMapping(value="/selectById",method = RequestMethod.GET)
    public String SelectGuest_InfoById(@RequestParam(value="id")int id){
    	Guest_Info guest_info = guest_infoService.SelectGuest_InfoById(id);
    	return JSONHelper.toJSON(guest_info);
    }
}
