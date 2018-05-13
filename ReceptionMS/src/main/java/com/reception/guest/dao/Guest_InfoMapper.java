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
    @Delete("delete from guest_info where id = #{id}")
    int DeleteGuest_Info(int id);

    /**
     * 导出信息查询
     * @return
     */
    @Select("SELECT A . ID,A .guest_name,A .main_position,A .deputy_position,A .office_area,a. sex AS xb,"
    		+ "A .BIRTH_DATE AS birthDate,A . nation AS nation_name,A. education AS education_name,"
	        +"A .origin_place,A .telphone,A .phone,A .email,A .address,A .guest_type,A .remark FROM guest_info A")
    List<Guest_Info> SelectGuest_Info();
    
    
    /**
     * 初始化宾客信息
     * @return
     */
    @Select("SELECT a.* from guest_info a order by a.id")
    List<Guest_Info> SelectGuest_Infos();

    /**
     * 查询宾客信息
     * @return
     */
    @Select("select * from guest_info where id = #{id}")
    Guest_Info SelectGuest_InfoById(int id);
    
    /**
     * 查询全部图片的名字
     * @return
     */
    @Select("select url from guest_info where url is not null")
    List<String> selectUrl();
}
