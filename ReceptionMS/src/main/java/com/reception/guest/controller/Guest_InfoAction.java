package com.reception.guest.controller;

import com.reception.guest.entity.Guest_Info;
import com.reception.guest.service.Guest_InfoService;
import com.reception.util.JSONHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value = "/insert" , method =  RequestMethod.PUT)
    public int InsertGuest_Info(@RequestBody Guest_Info guest_info){
        return guest_infoService.InsertGuest_Info(guest_info);
    }

    @RequestMapping(value = "/update" , method =  RequestMethod.PUT)
    public int UpdateGuest_Info(@RequestBody Guest_Info guest_info){
        return guest_infoService.UpdateGuest_Info(guest_info);
    }

    @RequestMapping(value = "/delete" , method =  RequestMethod.DELETE)
    public int DeleteGuest_Info(@RequestParam("guest_name") String guest_name){
        return guest_infoService.DeleteGuest_Info(guest_name);
    }

    @RequestMapping(value = "/select" , method =  RequestMethod.GET)
    public String DeleteGuest_Info(){
        List<Guest_Info> guest_infos = guest_infoService.SelectGuest_Info();
        return JSONHelper.toJSON(guest_infos);
    }

}
