package com.reception.system.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.reception.exceptionfilter.EntityNotFoundException;
import com.reception.system.model.Role;
import com.reception.system.model.RoleModule;
import com.reception.system.model.User;
import com.reception.system.service.RoleServiceImpl;
import com.reception.util.JSONHelper;

/**
 * 角色管理controller层
 */
@RestController
@RequestMapping(value = "/role")
public class RoleAction {
	// log日志
	private static final Logger logger = Logger.getLogger(RoleAction.class);

	// 注入roleService层
	@Resource
	RoleServiceImpl roleService;

	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = "json/plain; charset=utf-8")
	public @ResponseBody String selectList() {
		List<Role> list = roleService.selectList();
		String json = JSONHelper.toJSON(list);
		System.out.println(json);
		return json;
	}

	/**
	 * 查询角色
	 * 
	 * @param role
	 * @return string
	 */
	@RequestMapping(value = "/listByName", method = RequestMethod.POST, produces = "text/plain; charset=utf-8")
	public @ResponseBody String selectRoleList(@RequestParam(value = "roleName", required = false) String roleName,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") String pageSize,
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") String pageNum,
			HttpServletRequest req) {
		PageHelper.startPage(Integer.valueOf(pageNum), Integer.valueOf(pageSize));
		List<Role> list = roleService.selectListByName(roleName);
		PageInfo<Role> pageInfo = new PageInfo<Role>(list);
		String json = JSONHelper.toJSON(pageInfo);
//		System.out.println(json);
		return json;
	}

	// 通过roleid查询角色菜单
	@RequestMapping(value = "/selectRoleModule", produces = "json/plain; charset=utf-8")
	public @ResponseBody String selectRoleModule(String roleId) {
		List<RoleModule> list = roleService.selectRoleModule(roleId);
		String json = JSONHelper.toJSON(list);
//		System.out.println(json);
		return json;
	}

	/**
	 * 添加角色
	 * 
	 * @param role
	 * @return string
	 */
	@RequestMapping(value = "/add")
	public @ResponseBody String roleAdd(@ModelAttribute("role") Role role) {
		int num = roleService.addRole(role);
		if (num > 0) {
			logger.info("添加成功!");
			return "true";
		} else {
			logger.info("添加失败!");
			return "false";
		}
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String queryUserById(@PathVariable("id") String id) {
		Role role = this.roleService.selectById(id);
		if (role == null) {
			new EntityNotFoundException("不存在");
		}
		return JSONHelper.toJSON(role);
	}

	/**
	 * 修改角色信息
	 * 
	 * @param role
	 * @return string //
	 */
	@RequestMapping(value = "/update")
	public @ResponseBody String updateRole(@ModelAttribute("role") Role role) {

		int num = roleService.updateRole(role);
		if (num > 0) {
			String result = "true";
			return result;
		} else {
			String result = "false";
			return result;
		}
	}

	/**
	 * 删除角色
	 * 
	 * @param role
	 * @return string
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public String deleteRole(@PathVariable("id") String roleId) {
		String flag = "false";
		int i = roleService.deleteRole(roleId);
		if (i > 0) {
			flag = "true";
		}
		return flag;
	};

	/**
	 * 添加角色与功能模块的关系
	 * 
	 * @param role
	 * @return
	 */
	@RequestMapping(value="/setRoleModule", produces = "text/plain; charset=utf-8")
	public @ResponseBody String addRoleAndModule(@RequestParam(value = "roleId") String roleId,
												 @RequestParam(value = "menuIds") String menuIds) {
//		System.out.println(menuIds);
		String[] arr = menuIds.split(",");
		int i = roleService.setRoleModule(arr, roleId);
		if (i>0) {
			return "true";
		}
		return "false";

	}


}
