package com.reception.system.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reception.system.api.RoleService;
import com.reception.system.dao.RoleDao;
import com.reception.system.model.Role;
import com.reception.system.model.RoleModule;


/**
 * 角色管理service层
 */
@Service
public class RoleServiceImpl implements RoleService{

	@Resource
	RoleDao roleDao;
	
	@Override
	public int addRole(Role role) {
		// TODO Auto-generated method stub
		return roleDao.addRole(role);
	}

	@Override
	public int updateRole(Role role) {
		// TODO Auto-generated method stub
		return roleDao.updateRole(role);
	}

	@Override
	public int deleteRole(RoleModule roleModule) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Role> selectList(String roleName) {
		// TODO Auto-generated method stub
		return roleDao.selectList(roleName);
	}

	//设置角色功能模块
	@Override
	public int setRoleModule() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
