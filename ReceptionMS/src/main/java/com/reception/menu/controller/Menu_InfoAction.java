package com.reception.menu.controller;

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
import com.reception.menu.api.Menu_InfoApi;
import com.reception.menu.entity.Menu_Info;
import com.reception.util.JSONHelper;

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
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public @ResponseBody int InsertMenu_Info(Menu_Info menu_info,HttpServletRequest request){
        return menu_InfoApi.InsertMenu_Info(menu_info);
    }

    /**
     * 更新菜品信息
     * @param
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public void UpdateMenu_Info(Menu_Info menu_info,HttpServletRequest request){
        menu_InfoApi.UpdateMenu_Info(menu_info);
    }

    /**
     * 查询菜品信息
     * @return
     */
    @RequestMapping(value = "/select",method = RequestMethod.GET)
    @ResponseBody
    public String selectMenu_Info(@RequestParam(value="pageNum")String pageNum,@RequestParam(value="pageSize")String pageSize){
        PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
    	List<Menu_Info> list =  menu_InfoApi.SelectMenu_Info();
    	PageInfo<Menu_Info> pageInfo = new PageInfo<Menu_Info>(list);
    	String result = JSONHelper.toJSON(pageInfo);
       return result;
    }

    /**
     * 查询菜品信息
     * @return
     */
    @RequestMapping(value = "/selectById",method = RequestMethod.GET)
    @ResponseBody
    public String selectMenu_InfoByMenu_num(@RequestParam("id") int id){
        Menu_Info menu_info =  menu_InfoApi.selectMenu_InfoById(id);
        String result = JSONHelper.toJSON(menu_info);
        return result;
    }

    /**
     * 查询菜品信息
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    @ResponseBody
    public int deleteMenu_Info(@RequestParam("id")int id){
        return  menu_InfoApi.deleteMenu_Info(id);
    }
}
