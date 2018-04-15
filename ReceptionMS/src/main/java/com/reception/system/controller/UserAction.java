package com.reception.system.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.reception.system.model.User;
import com.reception.system.service.UserServiceImpl;
import com.reception.util.JSONHelper;

/**
 * 用户Action层
 */
@RestController
@RequestMapping(value = "/user")
public class UserAction {
	// log日志
	private static final Logger logger = Logger.getLogger(UserAction.class);
	// 注入service层
	@Resource
	UserServiceImpl userService;

	/**
	 * 添加用户
	 * @param user
	 * @return String
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String UserAdd(@ModelAttribute("user") User user, HttpSession session) {
		String result = "false";

		int num = userService.isExistUser(user);
		if (num == 1) {
			num = userService.addUser(user);
			result = "true";
			return result;
		} else {
			return result;
		}
	}

	/**
	 * 查询用户列表
	 * @param user
	 * @return String
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String queryUser(@RequestParam(value = "user_id", required = false) String user_id,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") String pageSize,
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") String pageNum,
			@RequestParam(value = "userName", required = false) String userName, HttpServletRequest req) {
		// 执行查询
		Map<String, String> map = new HashMap<String, String>();

		HttpSession session = req.getSession();
		long total = PageHelper.count(() -> {
			userService.selectList(userName);
		});
		PageHelper.startPage(Integer.valueOf(pageNum), Integer.valueOf(pageSize));
		Page page = PageHelper.getLocalPage();
		// 总页数
		long totalPage = total / page.getPageSize() + ((total % page.getPageSize() == 0) ? 0 : 1);

		List<User> users = userService.selectList(userName);
		String jsonlist = JSONHelper.toJSON(users);
		return jsonlist;
	}

	/**
	 * 修改用户信息
	 * @param user
	 * @return String
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String updateUser(@ModelAttribute("user") User user, HttpSession session) {

		// 查询要修改的User
		int num = userService.updateUser(user);
		if (num == 1) {
			return "true";
		} else {
			return "false";
		}
	}

	/**
	 * 删除用户
	 * 
	 * @param user
	 * @return String
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String deleteUser(User user) {
		int num = userService.deleteUser(user);
		if (num > 0) {
			return "true";
		} else {
			return "false";
		}

	}

}
