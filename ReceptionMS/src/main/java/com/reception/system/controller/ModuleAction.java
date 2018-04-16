package com.reception.system.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.reception.system.model.Module;
import com.reception.system.service.ModuleServiceImpl;
import com.reception.util.JSONHelper;

@RestController
@RequestMapping(value = "/module")
public class ModuleAction {
	// log日志
	//private static final Logger logger = Logger.getLogger(ModuleAction.class);
	// 注入service
	@Resource
	 ModuleServiceImpl moduleServiceImpl;

	/**
	 * 添加菜单
	 * 
	 * @param module
	 * @return String
	 */
	@RequestMapping(value = "/add")
	public @ResponseBody String moduleAdd(Module module, HttpSession session) {
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
	public @ResponseBody String deleteModuleAndRole(String module_id) {
		String result = "false";
		try {
			// moduleServiceImpl.deletemoduleAndRole(module_id);
			result = "true";
		} catch (Exception e) {
			result = "false";
		}
		return result;

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
	public @ResponseBody String queryModuleList(
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") String pageSize,
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") String pageNum,
			@RequestParam(value = "moduleName", required = false) String moduleName) {

		long total = PageHelper.count(() -> {
			moduleServiceImpl.selectModuleList(moduleName);
		});
		PageHelper.startPage(Integer.valueOf(pageNum), Integer.valueOf(pageSize));
		Page page = PageHelper.getLocalPage();
		long totalPage = total / page.getPageSize() + ((total % page.getPageSize() == 0) ? 0 : 1);// 总页数

		List<Module> list = moduleServiceImpl.selectModuleList(moduleName);
		JSONHelper jsonHelper = new JSONHelper();
		String json = jsonHelper.toJSON(list);
		return json;
	}

	// 用户登录后查询一级菜单目录
	@RequestMapping(value = "/show", produces = "application/json; charset=utf-8")
	public @ResponseBody String getmodulesRoot(HttpSession session) {
		// Login login = (Login)session.getAttribute("login");
		List<Module> list = moduleServiceImpl.selectModuleByRole("0"); // 超级管理员role_id为0
		JSONHelper jsonHelper = new JSONHelper();
		String json = jsonHelper.toJSON(list);
		System.out.println(json);
		return json;
	}

}
