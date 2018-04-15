package com.reception.menu.api;

import com.reception.menu.entity.Menu_Info;

import java.util.List;

/**
 * @author zhangwei
 * @description  菜品信息管理API
 * @date created in 16:46 2018/4/12
 * @throws Exception
 */
public interface Menu_InfoApi {
    /**
     * 插入菜品信息
     * @param menu_info
     * @return
     */
    int InsertMenu_Info(Menu_Info menu_info);

    /**
     * 更新菜品信息
     * @param menu_info
     * @return
     */
    int UpdateMenu_Info(Menu_Info menu_info);

    /**
     * 查询菜品信息
     * @return
     */
    List<Menu_Info> SelectMenu_Info();

    /**
     * 根据菜单编号查询套餐信息
     * @param menu_number
     * @return
     */
    Menu_Info selectMenu_InfoByMenu_num(String menu_number);

    /**
     * 删除彩品信息
     * @param menu_number
     * @return
     */
    int deleteMenu_Info(String menu_number);
}
