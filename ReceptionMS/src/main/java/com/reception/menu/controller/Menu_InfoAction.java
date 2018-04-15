package com.reception.menu.controller;

import com.reception.menu.api.Menu_InfoApi;
import com.reception.menu.entity.Menu_Info;
import com.reception.util.JSONHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhangwei
 * @description 菜品信息管理
 * @date created in 16:54 2018/4/12
 * @throws Exception
 */
@RestController
@RequestMapping("/menu_info")
public class Menu_InfoAction {
    private static final Logger log = LoggerFactory.getLogger(Menu_InfoAction.class);

    @Autowired
    private Menu_InfoApi menu_InfoApi;

    /**
     * 添加菜品信息
     * @param
     */
    @RequestMapping(value = "/insert",method = RequestMethod.PUT)
    public void InsertMenu_Info(@RequestBody Menu_Info menu_info){
        menu_InfoApi.InsertMenu_Info(menu_info);
    }

    /**
     * 更新菜品信息
     * @param
     */
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public void UpdateMenu_Info(@RequestBody Menu_Info menu_info){
        menu_InfoApi.UpdateMenu_Info(menu_info);
    }

    /**
     * 查询菜品信息
     * @return
     */
    @RequestMapping(value = "/select",method = RequestMethod.GET)
    @ResponseBody
    public String selectMenu_Info(){
       List<Menu_Info> list =  menu_InfoApi.SelectMenu_Info();
        String result = JSONHelper.toJSON(list);
       return result;
    }

    /**
     * 查询菜品信息
     * @return
     */
    @RequestMapping(value = "/selectByMenu_num",method = RequestMethod.POST)
    @ResponseBody
    public String selectMenu_InfoByMenu_num(@RequestParam("menu_number") String menu_number){
        Menu_Info menu_info =  menu_InfoApi.selectMenu_InfoByMenu_num(menu_number);
        String result = JSONHelper.toJSON(menu_info);
        return result;
    }

    /**
     * 查询菜品信息
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public int deleteMenu_Info(@RequestParam("menu_number")String menu_number){
        return  menu_InfoApi.deleteMenu_Info(menu_number);
    }
}
