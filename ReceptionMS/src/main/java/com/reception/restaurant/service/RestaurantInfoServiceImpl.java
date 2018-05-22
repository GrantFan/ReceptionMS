package com.reception.restaurant.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.reception.restaurant.api.IRestaurantInfoService;
import com.reception.restaurant.dao.RestaurantInfoMapper;
import com.reception.restaurant.model.RestaurantInfoEntity;
import com.reception.restaurant.model.RestaurantUtilEntity;

@Service
public class RestaurantInfoServiceImpl implements IRestaurantInfoService{

	@Resource
	private RestaurantInfoMapper restaurantInfoMapper;
	
	@Override
	public void addRestaurantInfo(RestaurantInfoEntity restaurantInfoEntity) {
		restaurantInfoEntity.setRestaurant_number(this.restaurantInfoMapper.getrestaurant_number());
		restaurantInfoEntity.setId(String.valueOf(System.currentTimeMillis())); 
		restaurantInfoMapper.addRestaurantInfo(restaurantInfoEntity); 
	}

	@Override
	public boolean delRestaurantInfo(String[] id) {
		
		return id.length == this.restaurantInfoMapper.delRestaurantInfo(id);
	}

	@Override
	public boolean modRestaurantInfo(RestaurantInfoEntity restaurantInfoEntity) {
		
		return 1 == this.restaurantInfoMapper.modRestaurantInfo(restaurantInfoEntity);
	}

	@Override
	public RestaurantInfoEntity queryRestaurantInfoById(String id) {
		// TODO Auto-generated method stub
		return this.restaurantInfoMapper.queryRestaurantInfoById(id);
	}

	@Override
	public List<RestaurantInfoEntity> queryRestaurantInfoByPage(Map map) {
		// TODO Auto-generated method stub
		return this.restaurantInfoMapper.queryRestaurantInfoByPage(map);
	}
	@Override
	public List<RestaurantUtilEntity> restaurantUtilEntity(String hotel_name){
		return this.restaurantInfoMapper.restaurantUtilEntity(hotel_name);
	}
	@Override
	public String getrestaurant_number(){
		return this.restaurantInfoMapper.getrestaurant_number();
	}
}
