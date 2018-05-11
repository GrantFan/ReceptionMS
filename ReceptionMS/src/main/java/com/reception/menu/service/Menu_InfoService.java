package com.reception.menu.service;

import com.reception.menu.api.Menu_InfoApi;
import com.reception.menu.dao.Menu_InfoMapper;
import com.reception.menu.entity.Food_Info;
import com.reception.menu.entity.Menu_Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhangwei
 * @description  套餐信息管理service
 * @date created in 16:48 2018/4/12
 * @throws Exception
 *
 */
@Service
public class Menu_InfoService implements Menu_InfoApi {

    private static final Logger log = LoggerFactory.getLogger(Menu_InfoService.class);
    @Autowired
    private Menu_InfoMapper menu_InfoMapper;

    /**
     * 插入套餐信息
     * @param menu_info
     * @return
     */
    @Transactional
    @Override
    public int InsertMenu_Info(Menu_Info menu_info) {
    	int max_id = menu_InfoMapper.selectMaxId();
    	menu_info.setId(max_id);
    	menu_info.setMenu_number("T"+max_id);
        int num = menu_InfoMapper.InsertMenu_Info(menu_info);
        if(num > 0) {
            for (Food_Info food_info : menu_info.getFood_infos()) {
            	food_info.setFood_number("T"+max_id);
                num = menu_InfoMapper.InsertFood_Info(food_info);
            }
        }
        return num;
    }

    /**
     * 更新套餐信息
     * @param menu_info
     * @return
     */
    @Override
    public int UpdateMenu_Info(Menu_Info menu_info) {
        //1.更新套餐信息
        int num = menu_InfoMapper.UpdateMenu_Info(menu_info);
        if(num > 0){
            //2.执行删除菜品信息
           menu_InfoMapper.deleteFood_Info(menu_info.getMenu_number());
           if(menu_info.getFood_infos() != null){
	           for(Food_Info food_info : menu_info.getFood_infos()) {
	        	   food_info.setFood_number(menu_info.getMenu_number());
	        	   //插入菜品信息
	        	   num = menu_InfoMapper.InsertFood_Info(food_info);
	           }
           }
          }
        return num;
    }

    /**
     * 查询套餐信息
     * @return
     */
    @Override
    public List<Menu_Info> SelectMenu_Info() {
        List<Food_Info> food_infos = null;
        List<Menu_Info>  menu_infos = menu_InfoMapper.selectMenu_Info();
        for(Menu_Info menu_info : menu_infos){
             food_infos = menu_InfoMapper.SelectFood_Info(menu_info.getMenu_number());
            menu_info.setFood_infos(food_infos);
        }
        return menu_infos;
    }

    /**
     * 根据套餐id，查询套餐信息
     * @param id
     * @return
     */
    @Override
    public Menu_Info selectMenu_InfoById(String menu_number) {
        Menu_Info  menu_info = menu_InfoMapper.selectMenu_InfoById(menu_number);
        List<Food_Info> food_infos = menu_InfoMapper.SelectFood_Info(menu_info.getMenu_number());
        menu_info.setFood_infos(food_infos);
        return menu_info;
    }

    /**
     * 删除套餐信息
     * @param id
     * @return
     */
    @Override
    public int deleteMenu_Info(String menu_number) {
        int num = menu_InfoMapper.deleteMenu_Info(menu_number);
        if(num > 0){
            num =  menu_InfoMapper.deleteFood_Info(menu_number);
        }
        return num;
    }
    
    /**
     * 查询菜品信息
     * @return
     */
    @Override
    public List<Food_Info> SelectFood_InfoList(){
    	return menu_InfoMapper.SelectFood_InfoList();
    }

	@Override
	public List<Menu_Info> selectByHotel(String hotel) {
		// TODO Auto-generated method stub
		return menu_InfoMapper.selectByHotel(hotel) ;
	}

}
