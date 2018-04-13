package com.reception.system.api;

import java.util.List;


import com.reception.system.model.User;


/**
 * 用户管理
 */
public interface UserService {
	
	int addUser(User user) ;
	
	List<User> selectList(String userName) ;
	
	int updateUser(User user) ;
	
	int deleteUser(User user) ;
}
