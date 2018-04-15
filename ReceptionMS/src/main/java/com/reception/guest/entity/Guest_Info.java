package com.reception.guest.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangwei
 * @description  宾客信息
 * @date created in 14:19 2018/4/13
 * @throws Exception
 */
public class Guest_Info implements Serializable{
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 宾客姓名
     */
    private String guest_name;
    /**
     * 主职务
     */
    private String main_position;
    /**
     * 副职务
     */
    private String deputy_position;
    /**
     * 任职地区
     */
    private String office_area;
    /**
     * 性别
     */
    private String sex;
    /**
     * 年龄
     */
    private String age;
    /**
     * 出生日期
     */
    private Date birth_date;
    /**
     * 民族
     */
    private Integer nation;
    /**
     * 学历
     */
    private Integer education;
    /**
     * 籍贯
     */
    private String origin_place;
    /**
     * 联系电话
     */
    private String telphone;
    /**
     * 家庭/办公电话
     */
    private String phone;
    /**
     * 邮件地址
     */
    private String email;
    /**
     * 家庭地址
     */
    private String address;
    /**
     * 宾客类型
     */
    private String guest_type;
    /**
     * 备注
     */
    private String remark;

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public Integer getNation() {
        return nation;
    }

    public void setNation(Integer nation) {
        this.nation = nation;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
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

    @Override
    public String toString() {
        return "Guest_Info{" +
                "id=" + id +
                ", guest_name='" + guest_name + '\'' +
                ", main_position='" + main_position + '\'' +
                ", deputy_position='" + deputy_position + '\'' +
                ", office_area='" + office_area + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", birth_date=" + birth_date +
                ", nation=" + nation +
                ", education=" + education +
                ", origin_place='" + origin_place + '\'' +
                ", telphone='" + telphone + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", guest_type='" + guest_type + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
