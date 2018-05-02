package com.reception.menu.dao;

import com.reception.menu.dao.sqlMapper.Menu_InfoSql;
import com.reception.menu.entity.Food_Info;
import com.reception.menu.entity.Menu_Info;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zhangwei
 * @description 套餐信息Mapper层
 * @date created in 14:38 2018/4/12
 * @throws Exception
 */

@Mapper
public interface Menu_InfoMapper {

    /**
     * 添加套餐信息
     * @param menu_info
     * @return
     */
    @InsertProvider(type = Menu_InfoSql.class,method = "InsertMenu_Info")
    int InsertMenu_Info(Menu_Info menu_info);

    /**
     * 更新套餐信息
     * @param menu_info
     * @return
     */
    @UpdateProvider(type = Menu_InfoSql.class,method = "UpdateMenu_Info")
    int UpdateMenu_Info(Menu_Info menu_info);

    /**
     * 查询套餐信息
     * @return
     */
    @Select("select * from MENU_INFO m")
    List<Menu_Info> selectMenu_Info();

    /**
     * 根据套餐id，查询套餐信息
     * @param menu_number
     * @return
     */
    @Select("select * from MENU_INFO m where m.id=#{id}")
    Menu_Info selectMenu_InfoById(int id);

    /**
     * 删除套餐信息
     * @param id
     * @return
     */
    @Delete("delete  from MENU_INFO where id=#{id}")
    int deleteMenu_Info(int id);

    /**
     * 添加菜品信息
     * @param food_info
     * @return
     */
    @InsertProvider(type = Menu_InfoSql.class,method = "InsertFood_Info")
    int InsertFood_Info(Food_Info food_info);

    /**
     * 删除菜品信息
     * @param id
     * @return
     */
    @Delete("delete  from FOOD_INFO where id=#{id}")
    int deleteFood_Info(int id);

    /**
     * 查询菜品信息
     * @param food_number
     * @return
     */
    @Select("select * from food_info where food_number=#{food_number}")
    List<Food_Info> SelectFood_Info(String food_number);
}
