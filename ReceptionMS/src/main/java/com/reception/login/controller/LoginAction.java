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
import com.reception.util.Md5Util;

@RestController
public class LoginAction {

	@Resource
	LoginServiceImpl loginService;

	@RequestMapping(value = "/login")
	public @ResponseBody String login(User user, HttpSession session) {
		InetAddress comp = null;
		String ip = "";
		String hostName = "";
		user.setPassword(Md5Util.EncoderByMd5(user.getPassword()));
		User login = loginService.login(user);
		if (login != null) {
			try {
				
				comp = InetAddress.getLocalHost();
				ip = comp.getHostAddress().toString(); // 获得机器IP
				hostName = comp.getHostName().toString(); // 获得机器名称
				user.setLastLoginComputer(hostName + ":" + ip);
				// 记录登录时间及机器
				loginService.loginLog(user);
				login.setLastLoginComputer(hostName + ":" + ip);
				session.setAttribute("user", login);
				return login.getUserName()+";"+login.getUserNick();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "false";
			}

		}
		return "false";
	}

	@RequestMapping(value = "/logout")
	public @ResponseBody String login(HttpSession session) {
		if (null != session.getAttribute("user")) {
			session.removeAttribute("user");
			return "true";
		}
		return "false";
	}
}
