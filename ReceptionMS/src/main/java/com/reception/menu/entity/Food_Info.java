package com.reception.menu.entity;

import java.io.Serializable;

import com.reception.util.poi.ModelProp;
import com.reception.util.poi.ModelTitle;

/**
 * @author zhangwei
 * @description 菜品信息管理
 * @date created in 18:59 2018/4/12
 * @throws Exception
 */
@ModelTitle(name="菜单信息")
public class Food_Info implements Serializable{

    /**
     * 主键id
     */
   private Integer id;
    /**
     * 套餐编号
     */
   @ModelProp(name="套餐编号",colIndex=1)
   private String food_number = "";
    /**
     * 菜品名称
     */
   @ModelProp(name="菜品名称",colIndex=2)
   private String food_name= "";
    /**
     * 菜品单价
     */
   @ModelProp(name="菜品单价",colIndex=3)
   private String price= "";
    /**
     * 菜品口味
     */
   @ModelProp(name="菜品口味",colIndex=4)
   private String flavor= "";
    /**
     * 菜品类型（热菜/凉菜/主食/土产/饮品
     */
   @ModelProp(name="菜品类型",colIndex=5)
   private String type= "";
    /**
     * 备注
     */
   @ModelProp(name="备注",colIndex=6)
   private String remark= "";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFood_number() {
        return food_number;
    }

    public void setFood_number(String food_number) {
        this.food_number = food_number;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Food_Info{" +
                "id=" + id +
                ", food_number='" + food_number + '\'' +
                ", food_name='" + food_name + '\'' +
                ", price=" + price +
                ", flavor='" + flavor + '\'' +
                ", type='" + type + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
