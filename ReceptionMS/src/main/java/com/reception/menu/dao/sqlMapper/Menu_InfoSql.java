package com.reception.menu.dao.sqlMapper;

import com.reception.menu.entity.Food_Info;
import com.reception.menu.entity.Menu_Info;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.LoggerFactory;


/**
 * @author zhangwei
 * @description   sql管理类
 * @date created in 14:46 2018/4/12
 * @throws Exception
 */
public class Menu_InfoSql {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(Menu_InfoSql.class);


    /**
     * t添加套餐信息
     * @param menu_info
     * @return
     */
    public String  InsertMenu_Info(Menu_Info menu_info){
        String sql = new SQL(){
            {
                INSERT_INTO("MENU_INFO");
                VALUES(" MENU_NUMBER", "#{menu_number}");
                VALUES(" SHORT_NAME","#{short_name}");
                VALUES(" MENU_TYPE","#{menu_type}");
                VALUES(" HOTEL","#{hotel}");
                VALUES(" MEALS_TIME","#{meals_time}");
                VALUES(" MEALS_TYPE","#{meals_type}");
                VALUES(" STANDARD","#{standard}");
                VALUES(" REMARK","#{remark}");
            }
        }.toString();
        log.info("插入套餐信息："+sql.toString());
          return  sql;
    }

    /**
     * 更新套餐信息
     * @param menu_info
     * @return
     */
    public String  UpdateMenu_Info(Menu_Info menu_info){
        String sql = new SQL(){
            {
               UPDATE("MENU_INFO");
                SET(" MENU_NUMBER=#{menu_number}");
                SET(" SHORT_NAME=#{short_name}");
                SET(" MENU_TYPE=#{menu_type}");
                SET(" HOTEL=#{hotel}");
                SET(" MEALS_TIME=#{meals_time}");
                SET(" MEALS_TYPE=#{meals_type}");
                SET(" STANDARD=#{standard}");
                SET(" REMARK=#{remark}");
                WHERE("ID=#{id}");
            }
        }.toString();
        log.info("更新套餐信息："+sql.toString());
        return  sql;
    }

    /**
     * t添加套餐信息
     * @param food_info
     * @return String
     */
    public String  InsertFood_Info(Food_Info food_info){
        String sql = new SQL(){
            {
                INSERT_INTO("FOOD_INFO");
                VALUES(" food_number", "#{food_number}");
                VALUES(" food_name","#{food_name}");
                VALUES(" price","#{price}");
                VALUES(" flavor","#{flavor}");
                VALUES(" type","#{type}");
                VALUES(" remark","#{remark}");
            }
        }.toString();
        log.info("插入菜品信息："+sql.toString());
        return  sql;
    }

}
