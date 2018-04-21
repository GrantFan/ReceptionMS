package com.reception.login.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.reception.login.api.LoginService;
import com.reception.login.dao.LoginDao;
import com.reception.system.model.User;

@Service
public class LoginServiceImpl implements LoginService {

	@Resource
	LoginDao loginDao;
	
	@Override
	public String login(User user) {
		// TODO Auto-generated method stub
		String userNick = loginDao.login(user);
		if("".equals(userNick) || null == userNick){
			return "false";
		}
		return userNick;
	}

	@Override
	public int loginLog(User user) {
		// TODO Auto-generated method stub
		return loginDao.loginLog(user);
	}

}
