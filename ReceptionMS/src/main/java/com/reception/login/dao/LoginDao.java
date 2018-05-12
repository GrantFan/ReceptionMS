package com.reception.login.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.reception.system.model.User;

@Mapper
public interface LoginDao {

	@Select("SELECT u.ID, u.user_name userName, u.user_nick userNick, u.last_login_computer lastLoginComputer, u.last_login_time lastLoginTime, u.create_time createTime, u.modify_time modifyTime, u.enabled, u.role_id roleId FROM sys_user u where user_name=#{userName} and password=#{password}")
	User login(User user);
	
	@Update("update sys_user set last_login_computer=#{lastLoginComputer},last_login_time=sysdate where user_name=#{userName}")
	int loginLog(User user);
}
