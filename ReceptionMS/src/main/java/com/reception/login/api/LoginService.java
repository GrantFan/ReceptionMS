package com.reception.login.api;

import com.reception.system.model.User;

public interface LoginService {

	String login(User user);
	
	int loginLog(User user);
	
}
