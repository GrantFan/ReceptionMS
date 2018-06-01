package com.reception.system.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.reception.exceptionfilter.EntityNotFoundException;
import com.reception.operate_log.util.LogAnnotation;
import com.reception.system.model.User;
import com.reception.system.service.UserServiceImpl;
import com.reception.util.JSONHelper;
import com.reception.util.Md5Util;

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
	@LogAnnotation(module = "用户设置",remark = "添加用户")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String UserAdd(@ModelAttribute("user") User user, HttpSession session) {
		String result = "false";
		int num = userService.isExistUser(user);
		if (num == 0) {
			user.setPassword(Md5Util.EncoderByMd5(user.getPassword()));
			num = userService.addUser(user);
			result = "true";
		} else {
			result = "exist";
		}
		return result;
	}

	/**
	 * 查询用户列表
	 * @param user
	 * @return String
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String queryUser(@RequestParam(value="userName",required = false,defaultValue = "")String userName,
			@RequestParam(value="pageNum",required = false,defaultValue = "1")String pageNum,
			@RequestParam(value="pageSize",required = false,defaultValue = "10")String pageSize) {
		PageHelper.startPage(Integer.valueOf(pageNum), Integer.valueOf(pageSize));
		List<User> list = userService.selectList(userName);
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		String json = JSONHelper.toJSON(pageInfo);
//		System.out.println(json);
		return json;
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String queryUserById(@PathVariable("id") String id) {
		User user = this.userService.selectById(id);
		if (user == null) {
			new EntityNotFoundException("不存在");
		}
		return JSONHelper.toJSON(user);
	}
	
	@LogAnnotation(module = "用户设置",remark = "删除用户")
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public String deleteHotelInfo(@ModelAttribute("user") User user) {
		String flag = "false";
		int i = userService.deleteUser(user);
		if (i > 0) {
			flag = "true";
		}
		return flag;
	};
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return String
	 */
	@LogAnnotation(module = "用户设置",remark = "修改用户")
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String updateUser(User user) {

		// 查询要修改的User
		user.setPassword(Md5Util.EncoderByMd5(user.getPassword()));
		int num = userService.updateUser(user);
		if (num > 0) {
			return "true";
		} else {
			return "false";
		}
	}

	/**
	 * 修改用户信息
	 * @param user
	 * @return String
	 */
	@LogAnnotation(module = "修改密码",remark = "用户修改密码")
	@RequestMapping(value = "/updatePass", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String updateUserPass(User user) {
		// 查询要修改的User
		user.setPassword(Md5Util.EncoderByMd5(user.getPassword()));
		int num = userService.updateUser(user);
		if (num > 0) {
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
	@LogAnnotation(module = "用户设置",remark = "删除用户")
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
