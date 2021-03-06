package com.reception.system.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reception.system.api.ModuleService;
import com.reception.system.dao.ModuleDao;
import com.reception.system.model.Module;

/**
 * 菜单管理service层
 *
 */
@Service
public class ModuleServiceImpl implements ModuleService{

	@Resource
	ModuleDao moduleDao;
	
	@Override
	public int addModule(Module module) {
		// TODO Auto-generated method stub
		return moduleDao.addModule(module);
	}

	@Override
	public int updateModule(Module module) {
		// TODO Auto-generated method stub
		return moduleDao.updateModule(module);
	}

	@Override
	public int deleteModule(String module) {
		// TODO Auto-generated method stub
		return moduleDao.deleteModule(module);
	}

	@Override
	public List<Module> selectModuleList() {
		// TODO Auto-generated method stub
		return moduleDao.selectModuleList();
	}

	@Override
	public List<Module> selectModuleByRole(String role_id) {
		// TODO Auto-generated method stub
		return moduleDao.selectModuleByRole(role_id);
	}

	@Override
	public List<Module> selectModuleListByName(String moduleName) {
		// TODO Auto-generated method stub
		return moduleDao.selectModuleListByName(moduleName);
	}

	public Module selectModuleById(String id) {
		// TODO Auto-generated method stub
		return moduleDao.selectModuleById(id);
	}
	
	
}
