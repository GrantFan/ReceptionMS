package com.reception.guest.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.reception.util.poi.ModelProp;
import com.reception.util.poi.ModelTitle;

/**
 * @author zhangwei
 * @description  宾客信息
 * @date created in 14:19 2018/4/13
 * @throws Exception
 */
@ModelTitle(name="宾客信息")
public class Guest_Info implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 主键id
     */
    private Integer id;
    /**
     * 宾客姓名
     */
	@ModelProp(name="宾客姓名",colIndex=0)
    private String guest_name = "";
    /**
     * 主职务
     */
	@ModelProp(name="主职务",colIndex=1)
    private String main_position  = "";
    /**
     * 副职务
     */
	@ModelProp(name="副职务",colIndex=2)
    private String deputy_position  = "";
    /**
     * 任职地区
     */
	@ModelProp(name="任职地区",colIndex=3)
    private String office_area = "";
    /**
     * 性别
     */
	 @ModelProp(name="性别",colIndex=4)
    private String sex = "";
	
    /**
     * 出生日期
     */
    @ModelProp(name="出生日期",colIndex=5)
    private String birth_date;
    /**
     * 民族
     */
    @ModelProp(name="民族",colIndex=6)
    private String nation = "";
   
    /**
     * 菜品喜好
     */
    @ModelProp(name="菜品喜好",colIndex=7)
    private String menu = "";
    
    /**
     * 饮品喜好
     */
    @ModelProp(name="饮品喜好",colIndex=8)
    private String drink = "";
    
    /**
     * 口味喜好
     */
    @ModelProp(name="口味喜好",colIndex=9)
    private String flavor = "";
    
    /**
     * 住宿喜好
     */
    @ModelProp(name="住宿喜好",colIndex=10)
    private String sleep = "";
    /**
     * 籍贯
     */
	@ModelProp(name="籍贯",colIndex=11)
    private String origin_place = "";
   
    /**
     * 备注
     */
	@ModelProp(name="备注",colIndex=12)
    private String remark = "";
    
    private String url = "";

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGuest_name() {
		return guest_name;
	}

	public void setGuest_name(String guest_name) {
		this.guest_name = guest_name;
	}

	public String getMain_position() {
		return main_position;
	}

	public void setMain_position(String main_position) {
		this.main_position = main_position;
	}

	public String getDeputy_position() {
		return deputy_position;
	}

	public void setDeputy_position(String deputy_position) {
		this.deputy_position = deputy_position;
	}

	public String getOffice_area() {
		return office_area;
	}

	public void setOffice_area(String office_area) {
		this.office_area = office_area;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}


	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public String getSleep() {
		return sleep;
	}

	public void setSleep(String sleep) {
		this.sleep = sleep;
	}

	public String getOrigin_place() {
		return origin_place;
	}

	public void setOrigin_place(String origin_place) {
		this.origin_place = origin_place;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Guest_Info [id=" + id + ", guest_name=" + guest_name + ", main_position=" + main_position
				+ ", deputy_position=" + deputy_position + ", office_area=" + office_area + ", sex=" + sex
				+ ", birth_date=" + birth_date + ", nation=" + nation + ", menu=" + menu + ", drink=" + drink
				+ ", flavor=" + flavor + ", sleep=" + sleep + ", origin_place=" + origin_place + ", remark=" + remark
				+ ", url=" + url + "]";
	}


}
