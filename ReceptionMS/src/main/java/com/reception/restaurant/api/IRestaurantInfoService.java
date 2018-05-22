package com.reception.restaurant.api;

import java.util.List;
import java.util.Map;

import com.reception.restaurant.model.RestaurantInfoEntity;
import com.reception.restaurant.model.RestaurantUtilEntity;

public interface IRestaurantInfoService {
	
	public void addRestaurantInfo(RestaurantInfoEntity restaurantInfoEntity);
	

	public boolean delRestaurantInfo(String[] id);
	

	public boolean modRestaurantInfo(RestaurantInfoEntity restaurantInfoEntity);
	 

	public RestaurantInfoEntity queryRestaurantInfoById(String id);
	

	public List<RestaurantInfoEntity> queryRestaurantInfoByPage(Map map);
	
	public List<RestaurantUtilEntity> restaurantUtilEntity(String hotel_name);
	
	public String getrestaurant_number();
}
