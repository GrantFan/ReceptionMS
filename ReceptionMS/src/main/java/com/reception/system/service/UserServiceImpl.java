package com.reception.system.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reception.system.api.UserService;
import com.reception.system.dao.UserDao;
import com.reception.system.model.User;


/**
 * 用户Service层
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Resource
	UserDao userDao;
	
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	@Override
	public List<User> selectList(String userName) {
		// TODO Auto-generated method stub
		return userDao.selectList(userName);
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	@Override
	public int deleteUser(User user) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(user);
	}

	public int isExistUser(User user) {
		// TODO Auto-generated method stub
		return userDao.isExistUser(user);
	}

}
