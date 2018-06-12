package com.reception.guest.service;

import com.reception.guest.api.Guest_InfoApi;
import com.reception.guest.dao.Guest_InfoMapper;
import com.reception.guest.entity.Guest_Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangwei
 * @description
 * @date created in 16:06 2018/4/13
 * @throws Exception
 */
@Service
public class Guest_InfoService implements Guest_InfoApi{
    private static final Logger log = LoggerFactory.getLogger(Guest_InfoService.class);

    @Autowired
    private Guest_InfoMapper guest_InfoMapper;
    /**
     * 添加宾客信息
     * @param guest_info
     * @return
     */
    @Override
    public int InsertGuest_Info(Guest_Info guest_info) {
        return guest_InfoMapper.InsertGuest_Info(guest_info);
    }

    /**
     * 更新宾客信息
     * @param guest_info
     * @return
     */
    @Override
    public int UpdateGuest_Info(Guest_Info guest_info) {
        return guest_InfoMapper.UpdateGuest_Info(guest_info);
    }

    /**
     * 删除宾客信息
     * @param id
     * @return
     */
    @Override
    public int DeleteGuest_Info(int id) {
        return guest_InfoMapper.DeleteGuest_Info(id);
    }

    /**
     * 导出信息查询
     * @return
     */
    @Override
    public List<Guest_Info> SelectGuest_Info() {
        return guest_InfoMapper.SelectGuest_Info();
    }

    
    /**
     * 初始化宾客信息
     * @return
     */
    public List<Guest_Info> SelectGuest_Infos(String guestName) {
        return guest_InfoMapper.SelectGuest_Infos(guestName);
    }

    /**
     * 查询宾客信息
     * @param guest_name
     * @return
     */
    @Override
    public Guest_Info SelectGuest_InfoById(int id) {
        return guest_InfoMapper.SelectGuest_InfoById(id);
    }

    /**
     * 查询全部图片路径
     */
	@Override
	public List<String> selectUrl() {
		return guest_InfoMapper.selectUrl();
	}

	@Override
	public List<Guest_Info> SelectGuest_Infos() {
		// TODO Auto-generated method stub
		return guest_InfoMapper.SelectGuest_Infos("");
	}
    
    
}
