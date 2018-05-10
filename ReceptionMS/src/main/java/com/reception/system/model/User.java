package com.reception.system.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户类
 *
 */
public class User implements Serializable{
	
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;//用户id
	private String userName;//用户名
	private String userNick;//用户昵称
	private String password;//用户密码
	private String lastLoginComputer;//上次登录电脑
	private String lastLoginTime;//上次登录时间
	private String createTime;//创建时间 
	private String modifyTime;//修改时间
	private String enable;//是否使用
	private String roleId; //角色ID
	private String roleName; //角色名
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLastLoginComputer() {
		return lastLoginComputer;
	}
	public void setLastLoginComputer(String lastLoginComputer) {
		this.lastLoginComputer = lastLoginComputer;
	}
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
