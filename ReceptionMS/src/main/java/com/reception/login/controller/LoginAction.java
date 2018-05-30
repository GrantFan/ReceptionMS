package com.reception.login.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.reception.login.service.LoginServiceImpl;
import com.reception.system.model.User;
import com.reception.util.Md5Util;

@RestController
public class LoginAction {

	@Value("${spring.http.multipart.location}")
	private String location;

	@Resource
	LoginServiceImpl loginService;

	/*
	 * 登录
	 * */
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
				return login.getUserName() + ";" + login.getUserNick() + ";" + login.getId();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "false";
			}

		}
		return "false";
	}

	/*
	 * 登出
	 * */
	@RequestMapping(value = "/logout")
	public @ResponseBody String login(HttpSession session) {
		if (null != session.getAttribute("user")) {
			session.removeAttribute("user");
			return "true";
		}
		return "false";
	}

	/*
	 * app下载
	 * */
	@RequestMapping(value = "/app")
	public void downloadApp(HttpServletResponse response) {
		String filename = "接待管理APP";
		FileInputStream in = null;
		OutputStream out = null;
		try {
			response.setContentType("application/octet-stream;charset=utf-8");
			response.setHeader("Content-Disposition",
					"attachment;filename=" + URLEncoder.encode(filename, "UTF-8") + ".apk");
			response.addHeader("Pargam", "no-cache");
			response.addHeader("Cache-Control", "no-cache");

			File appFile = new File(location + "app/reception.apk");
			if (!appFile.isDirectory() || !appFile.exists()) {
				appFile.mkdir();
			}
			in = new FileInputStream(appFile);
			int index;
			byte[] bytes = new byte[1024];
			out = response.getOutputStream();
			while ((index = in.read(bytes)) != -1) {
				out.write(bytes, 0, index);
				out.flush();
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
