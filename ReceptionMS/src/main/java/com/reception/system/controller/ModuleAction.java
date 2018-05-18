package com.reception.system.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
import com.reception.system.model.Module;
import com.reception.system.model.User;
import com.reception.system.service.ModuleServiceImpl;
import com.reception.util.JSONHelper;

@RestController
@RequestMapping(value = "/module")
public class ModuleAction {
	@Resource
	ModuleServiceImpl moduleServiceImpl;

	/**
	 * 添加菜单
	 * 
	 * @param module
	 * @return String
	 */
	@RequestMapping(value = "/add")
	public @ResponseBody String moduleAdd(Module module) {
		String result = "false";
		int num = moduleServiceImpl.addModule(module);
		if (num > 0) {
			result = "true";// 添加成功
		} else {
			result = "false";// 添加失败
		}
		return result;
	}

	/**
	 * 删除菜单同时要删除与角色关系
	 * 
	 * @param module
	 * @return String
	 */
	@RequestMapping("/delete")
	public @ResponseBody String deleteModuleAndRole(@RequestParam(value = "id") String id) {
		String result = "false";
		int i = moduleServiceImpl.deleteModule(id);
		if (i > 0) {
			result = "true";
		}
		return result;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String queryModuleById(@PathVariable("id") String id) {
		Module modulee = this.moduleServiceImpl.selectModuleById(id);
		if (modulee == null) {
			new EntityNotFoundException("不存在");
		}
		return JSONHelper.toJSON(modulee);
	}

	/**
	 * 修改菜单
	 * 
	 * @param module
	 * @return string
	 */
	@RequestMapping(value = "/update")
	public @ResponseBody String updatemodule(@ModelAttribute("module") Module module) {
		int num = moduleServiceImpl.updateModule(module);
		if (num > 0) {
			return "true";
		} else {
			return "false";
		}
	}

	/**
	 * 查询菜单
	 * 
	 * @param module
	 * @return string
	 */
	@RequestMapping(value = "/list", produces = "application/json; charset=utf-8")
	public @ResponseBody String queryModuleList() {

		List<Module> list = moduleServiceImpl.selectModuleList();
		String json = JSONHelper.toJSON(list);
		return json;
	}

	/**
	 * 查询菜单
	 * 
	 * @param module
	 * @return string
	 */
	@RequestMapping(value = "/listByName", produces = "application/json; charset=utf-8")
	public @ResponseBody String queryModuleListByName(
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") String pageSize,
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") String pageNum,
			@RequestParam(value = "moduleName", required = false, defaultValue = "") String moduleName) {

		PageHelper.startPage(Integer.valueOf(pageNum), Integer.valueOf(pageSize));
		List<Module> list = moduleServiceImpl.selectModuleListByName(moduleName);
		PageInfo<Module> page = new PageInfo<Module>(list);
		String json = JSONHelper.toJSON(page);
		return json;
	}

	// 用户登录后查询一级菜单目录
	@RequestMapping(value = "/show", produces = "application/json; charset=utf-8")
	public @ResponseBody String getmodulesRoot(HttpSession session) {
		try {
			User user = (User) session.getAttribute("user");
			// System.out.println("角色："+user.getRoleId());
			if (null != user.getRoleId()) {
				List<Module> list = moduleServiceImpl.selectModuleByRole(user.getRoleId()); // 超级管理员role_id为0
				JSONHelper jsonHelper = new JSONHelper();
				String json = jsonHelper.toJSON(list);
				// System.out.println(json);
				return json;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "{\"result\":\"请重新登录~\"}";
		}
		return "{\"result\":\"请重新登录~\"}";
	}

}
