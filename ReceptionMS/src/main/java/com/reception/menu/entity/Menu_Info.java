package com.reception.menu.entity;

import java.io.Serializable;
import java.util.List;

import com.reception.util.poi.ModelProp;
import com.reception.util.poi.ModelTitle;

/**
 * @author zhangwei
 * @description 套餐信息管理
 * @date created in 10:44 2018/4/12
 * @throws Exception
 */
@ModelTitle(name="套餐信息")
public class Menu_Info implements Serializable{

    /*
     * 主键id
     */
    private Integer id;

    /**
     *套餐编号
     */
	@ModelProp(name="套餐编号",colIndex=0)
    private String  menu_number= "";
    /**
     * 套餐简称
     */
	@ModelProp(name="套餐简称",colIndex=1)
    private String short_name= "";
    /**
     * 套餐类型
     */
	@ModelProp(name="套餐类型",colIndex=2)
    private String menu_type= "";
    /**
     * 酒店
     */
	@ModelProp(name="酒店",colIndex=3)
    private String hotel= "";
    /**
     * 用餐时间
     */
	@ModelProp(name="用餐时间",colIndex=4)
    private String meals_time= "";
    /**
     * 用餐方式
     */
	@ModelProp(name="用餐方式",colIndex=5)
    private String meals_type;
    /**
     *标准分类
     */
	@ModelProp(name="标准分类",colIndex=6)
    private String standard= "";
    /**
     * 备注
     */
	@ModelProp(name="备注",colIndex=7)
    private String remark= "";

    /**
     * 菜品信息
     */
    private List<Food_Info> food_infos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenu_number() {
        return menu_number;
    }

    public void setMenu_number(String menu_number) {
        this.menu_number = menu_number;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getMenu_type() {
        return menu_type;
    }

    public void setMenu_type(String menu_type) {
        this.menu_type = menu_type;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getMeals_time() {
        return meals_time;
    }

    public void setMeals_time(String meals_time) {
        this.meals_time = meals_time;
    }

    public String getMeals_type() {
        return meals_type;
    }

    public void setMeals_type(String meals_type) {
        this.meals_type = meals_type;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Food_Info> getFood_infos() {
        return food_infos;
    }

    public void setFood_infos(List<Food_Info> food_infos) {
        this.food_infos = food_infos;
    }

    @Override
    public String toString() {
        return "Menu_Info{" +
                "id=" + id +
                ", menu_number='" + menu_number + '\'' +
                ", short_name='" + short_name + '\'' +
                ", menu_type='" + menu_type + '\'' +
                ", hotel='" + hotel + '\'' +
                ", meals_time='" + meals_time + '\'' +
                ", meals_type='" + meals_type + '\'' +
                ", standard='" + standard + '\'' +
                ", remark='" + remark + '\'' +
                ", food_infos=" + food_infos +
                '}';
    }
}
