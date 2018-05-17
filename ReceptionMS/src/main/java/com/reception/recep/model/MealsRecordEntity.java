package com.reception.recep.model;

import com.reception.util.poi.ModelProp;
import com.reception.util.poi.ModelTitle;

/*
 * 接待用餐记录实体
 */
@ModelTitle(name="用餐记录")
public class MealsRecordEntity {
	
	private String id;
	@ModelProp(name="接待编号",colIndex=0)
	private String receptionNumber;//接待编号
	@ModelProp(name="用餐酒店",colIndex=1)
	private String hotel;//酒店
	@ModelProp(name="套餐名称",colIndex=2)
	private String menuNumber;//套餐编号
	@ModelProp(name="用餐时间",colIndex=3)
	private String mealsTime;//用餐时间
	@ModelProp(name="客人用餐喜好",colIndex=4)
	private String hobby;//客人用餐喜好
	@ModelProp(name="登记时间",colIndex=5)
	private String recordTime;//登记时间
	@ModelProp(name="备注",colIndex=6)
	private String remark;//备用字段
	
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReceptionNumber() {
		return receptionNumber;
	}
	public void setReceptionNumber(String receptionNumber) {
		this.receptionNumber = receptionNumber;
	}
	public String getMenuNumber() {
		return menuNumber;
	}
	public void setMenuNumber(String menuNumber) {
		this.menuNumber = menuNumber;
	}
	public String getMealsTime() {
		return mealsTime;
	}
	public void setMealsTime(String mealsTime) {
		this.mealsTime = mealsTime;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	public String getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}
	
}
