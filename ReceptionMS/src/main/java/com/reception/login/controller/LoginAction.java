package com.reception.login.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.reception.login.service.LoginServiceImpl;
import com.reception.system.model.User;

@RestController
public class LoginAction {

	@Resource
	LoginServiceImpl loginService;

	@RequestMapping(value = "/login")
	public @ResponseBody String login(User user,HttpServletRequest request) {
		InetAddress comp = null;
		String ip = "";
		String hostName = "";
		String result = loginService.login(user);
		if (result.equals("false")) {
			return "false";
		} else {
			try {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				comp = InetAddress.getLocalHost();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ip = comp.getHostAddress().toString(); // 获得机器IP
			hostName = comp.getHostName().toString(); // 获得机器名称
			user.setLastLoginComputer(hostName + ":" + ip);
			//记录登录时间及机器
			loginService.loginLog(user);
			return result;
		}
	}
}
