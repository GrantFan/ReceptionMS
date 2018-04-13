package com.reception.system.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 角色管理
 */
public class Role implements Serializable{

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	
	//角色id
	private String id;
	
	//角色名称
	private String roleName;
	
	//描述DESCRIPTION
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
