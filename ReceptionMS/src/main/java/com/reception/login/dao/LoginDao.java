package com.reception.login.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.reception.system.model.User;

@Mapper
public interface LoginDao {

	@Select("select user_name from sys_user where user_name=#{userName} and password=#{password}")
	String login(User user);
	
	@Update("update sys_user set last_login_computer=#{lastLoginComputer},last_login_time=#{lastLoginTime} where user_name=#{userName}")
	int loginLog(User user);
}
