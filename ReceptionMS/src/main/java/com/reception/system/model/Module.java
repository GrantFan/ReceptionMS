package com.reception.system.model;

import java.io.Serializable;

/**
 * 功能模块实体
 */
public class Module implements Serializable{
	
	private Integer id;
	private String moduleName;  	//名称
	private String moduleId;   		//模块id
	private String moduleParentId;  //父级id
	private String moduleParentName;//父级名称
	private String url;  			//资源路径
	private String sort;       		//排序
	private String icon;		//图标
	private String   createTime;  	//创建时间
	private String remark;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleParentId() {
		return moduleParentId;
	}
	public void setModuleParentId(String moduleParentId) {
		this.moduleParentId = moduleParentId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getModuleParentName() {
		return moduleParentName;
	}
	public void setModuleParentName(String moduleParentName) {
		this.moduleParentName = moduleParentName;
	}
	
}
