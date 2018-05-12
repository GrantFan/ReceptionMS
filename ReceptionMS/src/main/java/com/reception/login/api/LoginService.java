package com.reception.login.api;

import com.reception.system.model.User;

public interface LoginService {

	User login(User user);
	
	int loginLog(User user);
	
}
