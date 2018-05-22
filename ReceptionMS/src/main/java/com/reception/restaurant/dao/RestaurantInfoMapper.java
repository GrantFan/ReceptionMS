package com.reception.restaurant.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.reception.restaurant.model.RestaurantInfoEntity;
import com.reception.restaurant.model.RestaurantUtilEntity;


@Mapper
public interface RestaurantInfoMapper {
	
	@Insert("INSERT INTO RESTAURANT_INFO VALUES"
			+ " (#{id}, #{restaurant_number}, #{restaurant_name}, #{restaurant_type}, #{hotel},"
			+ "#{position}, #{floor}, #{capacity_num}, #{state}, #{remark})")
	public void addRestaurantInfo(RestaurantInfoEntity restaurantInfoEntity);
	
	@Delete("<script>" 
			+ "DELETE FROM RESTAURANT_INFO" 
			+ " where id in "
			+ "<foreach collection=\"array\" item=\"id\"   "
            + " open=\"(\" close=\")\" separator=\",\"> "  
            + " #{id} " 
            + " </foreach>  "  
			+ "</script>")
	public int delRestaurantInfo(String[] id);
	
	@Update("UPDATE RESTAURANT_INFO SET "
			+ "restaurant_number = #{restaurant_number}, restaurant_name = #{restaurant_name}, restaurant_type = #{restaurant_type}, "
			+ "hotel = #{hotel},position = #{position},floor = #{floor},"
			+ "capacity_num = #{capacity_num}, state = #{state}, remark = #{remark}"
			+ "WHERE id = #{id}")
	public int modRestaurantInfo(RestaurantInfoEntity restaurantInfoEntity);
	 
	@Select("SELECT * FROM RESTAURANT_INFO WHERE id = #{id}")
	public RestaurantInfoEntity queryRestaurantInfoById(String id);
	
	@Select("<script>"
			+ "SELECT * FROM RESTAURANT_INFO "
			+ "WHERE 1 = 1 "
			+ " <if test=\" '' != hotel  and null != hotel\"> "
			+ " and hotel = #{hotel,jdbcType=VARCHAR} "
			+ " </if>"
			+ " <if test=\" '' != restaurantType  and null != restaurantType\"> "
			+ " and restaurant_type = #{restaurantType,jdbcType=VARCHAR} "
			+ " </if>"
			+ " ORDER BY restaurant_number "
			+ "</script>")
	public List<RestaurantInfoEntity> queryRestaurantInfoByPage(Map map);
	
	@Select("<script>"
			+ "SELECT DM.value,DM.name FROM RESTAURANT_INFO INFO "
			+ "LEFT JOIN DM_RESTAURANT_TYPE DM "
			+ "ON DM.NAME = INFO.restaurant_type "
			+ "WHERE 1 = 1 "
			+ " <if test=\" '' != _parameter  and null != _parameter\"> "
			+ " and hotel = #{_parameter,jdbcType=VARCHAR} "
			+ " </if>" 
			+ "</script>")
	public List<RestaurantUtilEntity> restaurantUtilEntity(String hotel_name);
	@Select("<script>"
			+ "SELECT nvl(MAX(restaurant_number),0)+1 FROM RESTAURANT_INFO INFO " 
			+ "</script>")
	public String getrestaurant_number();
 
}
