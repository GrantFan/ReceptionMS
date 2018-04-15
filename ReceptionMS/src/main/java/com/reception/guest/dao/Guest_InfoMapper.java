package com.reception.guest.dao;

import com.reception.guest.dao.sqlmapper.Guest_InfoSql;
import com.reception.guest.entity.Guest_Info;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * @author zhangwei
 * @description  宾客信息
 * @date created in 16:06 2018/4/13
 * @throws Exception
 */
@Mapper
public interface Guest_InfoMapper {


    /**
     * 添加宾客信息
     * @param guest_info
     * @return
     */
    @InsertProvider(type = Guest_InfoSql.class , method = "InsertGuest_Info")
     int InsertGuest_Info(Guest_Info guest_info);


    /**
     * 更新宾客信息
     * @param guest_info
     * @return
     */
    @UpdateProvider(type = Guest_InfoSql.class , method = "UpdateGuest_Info")
    int UpdateGuest_Info(Guest_Info guest_info);

    /**
     * 删除宾客信息
     * @param guest_name
     * @return
     */
    @Delete("delete from guest_info where guest_name = #{guest_name}")
    int DeleteGuest_Info(String guest_name);

    /**
     * 初始化宾客信息
     * @return
     */
    @Select("select * from guest_info")
    List<Guest_Info> SelectGuest_Info();

    /**
     * 查询宾客信息
     * @return
     */
    @Select("select * from guest_info where guest_name = #{guest_name}")
    Guest_Info SelectGuest_InfoByName(String guest_name);

}
