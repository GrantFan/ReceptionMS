package com.reception.system.api;

import java.util.List;


import com.reception.system.model.Module;

/**
 * 模块管理
 *
 */
public interface ModuleService{
	
	int addModule(Module module);
	
	int updateModule(Module module);
	
	int deleteModule(String module);
	
	List<Module> selectModuleListByName(String moduleName) ;
	
	List<Module> selectModuleByRole(String role_id) ;

	List<Module> selectModuleList();

}
