package com.reception.system.api;

import java.util.List;

import com.reception.system.model.Role;
import com.reception.system.model.RoleModule;

/**
 * 角色管理
 */
public interface RoleService {

	int addRole(Role role);
	
	int updateRole(Role role);
	
	int deleteRole(String id);
	
	int setRoleModule();//设置角色功能模块

//	int setRoleModule(RoleModule roleModule);
}
