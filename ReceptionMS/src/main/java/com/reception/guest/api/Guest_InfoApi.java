package com.reception.guest.api;

import com.reception.guest.dao.sqlmapper.Guest_InfoSql;
import com.reception.guest.entity.Guest_Info;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
 * @author zhangwei
 * @description
 * @date created in 16:06 2018/4/13
 * @throws Exception
 */
public interface Guest_InfoApi {


    /**
     * 添加宾客信息
     * @param guest_info
     * @return
     */
    int InsertGuest_Info(Guest_Info guest_info);


    /**
     * 更新宾客信息
     * @param guest_info
     * @return
     */
    int UpdateGuest_Info(Guest_Info guest_info);

    /**
     * 删除宾客信息
     * @param guest_name
     * @return
     */
    int DeleteGuest_Info(int id);

    /**
     * 导出信息查询
     * @return
     */
    List<Guest_Info> SelectGuest_Info();
    
    /**
     * 初始化宾客信息
     * @return
     */
    public List<Guest_Info> SelectGuest_Infos();

    /**
     * 查询宾客信息
     * @return
     */
    Guest_Info SelectGuest_InfoById(int id);

    /**
     * 查询全部图片路径
     * @return
     */
    List<String> selectUrl();
 }
