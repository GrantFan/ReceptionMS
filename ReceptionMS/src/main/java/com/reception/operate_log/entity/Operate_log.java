package com.reception.operate_log.entity;

public class Operate_log {

	/**
	 * id
	 */
	private Integer id;
	/**
	 * 操作人
	 */
	private String operator ="";
	/**
	 * 模块
	 */
	private String module ="";
	/**
	 * 操作时间
	 */
	private String time ="";
	
	/**
	 * 操作电脑ip
	 */
	private String compuer_ip="";
	
	/**
	 * 操作电脑名
	 */
	private String compuer_name="";
	/**
	 * 备注
	 */
	private String remark="";
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}

	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCompuer_ip() {
		return compuer_ip;
	}
	public void setCompuer_ip(String compuer_ip) {
		this.compuer_ip = compuer_ip;
	}
	public String getCompuer_name() {
		return compuer_name;
	}
	public void setCompuer_name(String compuer_name) {
		this.compuer_name = compuer_name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Operate_log [id=" + id + ", operator=" + operator + ", module=" + module + ", time=" + time
				+ ", compuer_ip=" + compuer_ip + ", compuer_name=" + compuer_name + ", remark=" + remark + "]";
	}
}
