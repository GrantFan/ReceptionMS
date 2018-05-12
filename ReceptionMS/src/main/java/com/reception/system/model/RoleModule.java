package com.reception.system.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 角色与模块关系实体
 *
 */
public class RoleModule implements Serializable {
	private Integer id;
	private String role_id;//角色标识
	private String module_id;//模块标识
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getModule_id() {
		return module_id;
	}
	public void setModule_id(String module_id) {
		this.module_id = module_id;
	}
	
}
