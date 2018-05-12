package com.reception.system.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reception.system.api.RoleService;
import com.reception.system.dao.RoleDao;
import com.reception.system.model.Role;
import com.reception.system.model.RoleModule;
import com.reception.system.model.User;

/**
 * 角色管理service层
 */
@Service
public class RoleServiceImpl implements RoleService {

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
	@Transactional(rollbackFor = Exception.class)
	public int deleteRole(String roleId) {
		// TODO Auto-generated method stub
		int i = roleDao.deleteRole(roleId);
		int j = roleDao.deleteRoleModule(roleId);
		if (i+j > 0) {
			return 1;
		}
		return 0;
	}

	public List<Role> selectListByName(String roleName) {
		// TODO Auto-generated method stub
		return roleDao.selectListByName(roleName);
	}

	public List<Role> selectList() {
		// TODO Auto-generated method stub
		return roleDao.selectList();
	}

	// 设置角色功能模块
	@Transactional(rollbackFor = Exception.class)
	public int setRoleModule(String[] menuIds,String roleId) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("roleId", roleId); 
		map.put("menuIds", menuIds);
		roleDao.deleteRoleModule(roleId);
		roleDao.addRoleModule(map);
		return 1;
	}

	public Role selectById(String id) {
		// TODO Auto-generated method stub
		return roleDao.selectById(id);
	}

	public List<RoleModule> selectRoleModule(String roleId){
		return roleDao.selectRoleModule(roleId);
	}

	@Override
	public int setRoleModule() {
		// TODO Auto-generated method stub
		return 0;
	}
}
