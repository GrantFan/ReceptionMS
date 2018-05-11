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
	@ModelProp(name="宾客姓名",colIndex=1)
    private String guest_name = "";
    /**
     * 主职务
     */
	@ModelProp(name="主职务",colIndex=2)
    private String main_position  = "";
    /**
     * 副职务
     */
	@ModelProp(name="副职务",colIndex=3)
    private String deputy_position  = "";
    /**
     * 任职地区
     */
	@ModelProp(name="任职地区",colIndex=4)
    private String office_area = "";
    /**
     * 性别
     */
	
    private String sex = "";
    
    @ModelProp(name="性别",colIndex=5)
	private String xb  = "";
	
    /**
     * 年龄
     */
    private String age = "";
    /**
     * 出生日期
     */
   
    private String birth_date;
    
    @ModelProp(name="出生日期",colIndex=6)
    private String birthDate;
    /**
     * 民族
     */
    private String nation = "";
    
    @ModelProp(name="民族",colIndex=7)
	private String nation_name = "";
    /**
     * 学历
     */
	
    private String education = "";
	
    @ModelProp(name="学历",colIndex=8)
	private String education_name = "";
    /**
     * 籍贯
     */
	@ModelProp(name="籍贯",colIndex=9)
    private String origin_place = "";
    /**
     * 联系电话
     */
	@ModelProp(name="联系电话",colIndex=10)
    private String telphone = "";
    /**
     * 家庭/办公电话
     */
	@ModelProp(name="家庭/办公电话",colIndex=11)
    private String phone = "";
    /**
     * 邮件地址
     */
	@ModelProp(name="邮件地址",colIndex=12)
    private String email = "";
    /**
     * 家庭地址
     */
	@ModelProp(name="家庭地址",colIndex=13)
    private String address = "";
    /**
     * 宾客类型
     */
	@ModelProp(name="宾客类型",colIndex=14)
    private String guest_type = "";
    /**
     * 备注
     */
	@ModelProp(name="备注",colIndex=15)
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

	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
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

	public String getNation_name() {
		return nation_name;
	}

	public void setNation_name(String nation_name) {
		this.nation_name = nation_name;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getEducation_name() {
		return education_name;
	}

	public void setEducation_name(String education_name) {
		this.education_name = education_name;
	}

	public String getOrigin_place() {
		return origin_place;
	}

	public void setOrigin_place(String origin_place) {
		this.origin_place = origin_place;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGuest_type() {
		return guest_type;
	}

	public void setGuest_type(String guest_type) {
		this.guest_type = guest_type;
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

	
	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Guest_Info [id=" + id + ", guest_name=" + guest_name + ", main_position=" + main_position
				+ ", deputy_position=" + deputy_position + ", office_area=" + office_area + ", sex=" + sex + ", xb="
				+ xb + ", age=" + age + ", birth_date=" + birth_date + ", birthDate=" + birthDate + ", nation=" + nation
				+ ", nation_name=" + nation_name + ", education=" + education + ", education_name=" + education_name
				+ ", origin_place=" + origin_place + ", telphone=" + telphone + ", phone=" + phone + ", email=" + email
				+ ", address=" + address + ", guest_type=" + guest_type + ", remark=" + remark + ", url=" + url + "]";
	}

}
