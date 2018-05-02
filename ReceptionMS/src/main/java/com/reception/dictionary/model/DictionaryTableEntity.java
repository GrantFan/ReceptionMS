package com.reception.dictionary.model;

/*
 * 字典表
 * */
public class DictionaryTableEntity {
	private String name;//字典名
	private String value;//键值
	private String tableName;//表名
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
}
