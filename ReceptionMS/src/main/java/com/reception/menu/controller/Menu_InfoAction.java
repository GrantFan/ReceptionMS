package com.reception.menu.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.reception.dictionary.model.DictionaryTableEntity;
import com.reception.guest.entity.Guest_Info;
import com.reception.menu.api.Menu_InfoApi;
import com.reception.menu.entity.Food_Info;
import com.reception.menu.entity.Menu_Info;
import com.reception.util.JSONHelper;
import com.reception.util.poi.ImportExcelUtil;
import com.reception.util.poi.ModelTitle;

/**
 * @author zhangwei
 * @description 菜品信息管理
 * @date created in 16:54 2018/4/12
 * @throws Exception
 */
@RestController
@RequestMapping(value="/menu_info", produces = "application/json; charset=utf-8")
public class Menu_InfoAction {
	private static final Logger log = LoggerFactory.getLogger(Menu_InfoAction.class);

	@Autowired
	private Menu_InfoApi menu_InfoApi;

//	@Value("${filePath}")
//	private String filePath;

	/**
	 * 添加菜品信息
	 * 
	 * @param
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.PUT)
	public @ResponseBody int InsertMenu_Info(@RequestBody Menu_Info menu_info) {
		return menu_InfoApi.InsertMenu_Info(menu_info);
	}

	/**
	 * 更新菜品信息
	 * 
	 * @param
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public @ResponseBody int UpdateMenu_Info(@RequestBody Menu_Info menu_info) {
		return menu_InfoApi.UpdateMenu_Info(menu_info);
	}

	/**
	 * 查询菜品信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	@ResponseBody
	public String selectMenu_Info(@RequestParam(value = "pageNum") String pageNum,
			@RequestParam(value = "pageSize") String pageSize) {
		PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
		List<Menu_Info> list = menu_InfoApi.SelectMenu_Info();
		PageInfo<Menu_Info> pageInfo = new PageInfo<Menu_Info>(list);
		String result = JSONHelper.toJSON(pageInfo);
		return result;
	}
	
	@RequestMapping(value = "/selectByHotel", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectByHotel(@RequestParam("hotel") String hotel) {
		List<Menu_Info> list = menu_InfoApi.selectByHotel(hotel);
		String result = JSONHelper.toJSON(list);
//		System.out.println(result);
		return result;
	}
	
	/**
	 * 查询菜品信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/selectById.app", method = RequestMethod.GET)
	@ResponseBody
	public String selectMenu_InfoByMenu_num(@RequestParam("menu_number") String menu_number,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		Menu_Info menu_info = menu_InfoApi.selectMenu_InfoById(menu_number);
		String result = JSONHelper.toJSON(menu_info);
		return result;
	}

	/**
	 * 查询菜品信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public int deleteMenu_Info(@RequestParam("menu_number") String menu_number) {
		return menu_InfoApi.deleteMenu_Info(menu_number);
	}

	/**
	 * 导出数据
	 * 
	 * @param request
	 * @param response
	 * @param path
	 * @return
	 */
	@RequestMapping(value = "/menu.xls",produces = "*/*; charset=utf-8")
	public @ResponseBody String exportMenu(HttpServletRequest request, HttpServletResponse response) {
		// 总行数
		long rowSize = PageHelper.count(() -> {
			menu_InfoApi.SelectMenu_Info();
		});
		// 将某列设为下拉列表
		Map<Integer, String[]> map = new HashMap<Integer, String[]>();
		// 导出数据集合
		List<Menu_Info> list = menu_InfoApi.SelectMenu_Info();
		// 导出
		InputStream input = ImportExcelUtil.excelModelbyClass(Menu_Info.class, map, (int) rowSize, list);
		OutputStream os = null;
		String fileName;
		int index;
		byte[] bytes = new byte[1024];
		try {
			response.setContentType("application/octet-stream;charset=utf-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("套餐信息", "UTF-8")
			+ ".xls;filename*=UTF-8''" + URLEncoder.encode("套餐信息", "UTF-8") + ".xls");
			//fileName = java.net.URLEncoder.encode("menu", "gb2312");
			//response.setContentType("application/octet-stream;charset=gb2312");
			// 设置title
			//response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xls");
			response.addHeader("Pargam", "no-cache");
			response.addHeader("Cache-Control", "no-cache");

			os = response.getOutputStream();
			while ((index = input.read(bytes)) != -1) {
				os.write(bytes, 0, index);
				os.flush();
			}
			exportFood(request,response);
			os.close();
			return "true";
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "false";
	}

	@RequestMapping(value = "/food.xls",produces = "*/*; charset=utf-8")
   public void exportFood(HttpServletRequest request,HttpServletResponse response) {
  		 // 总行数
		long rowSize = PageHelper.count(() -> {
			menu_InfoApi.SelectMenu_Info();
		});
		// 将某列设为下拉列表
		Map<Integer, String[]> map = new HashMap<Integer, String[]>();
		// 导出数据集合
		List<Food_Info> list = menu_InfoApi.SelectFood_InfoList();
		// 导出
		InputStream input = ImportExcelUtil.excelModelbyClass(Food_Info.class, map, (int) rowSize, list);
        OutputStream os = null;
       String fileName;
	   int index;
	   byte[] bytes = new byte[1024];
		try {
			response.setContentType("application/octet-stream;charset=utf-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("菜品信息", "UTF-8")
			+ ".xls;filename*=UTF-8''" + URLEncoder.encode("菜品信息", "UTF-8") + ".xls");
			//fileName = java.net.URLEncoder.encode("food", "gb2312");
			//response.setContentType("application/octet-stream;charset=gb2312");
		     //设置title
		    // response.setHeader("Content-Disposition", "attachment;filename="+fileName+".xls");
		       response.addHeader("Pargam", "no-cache");
		       response.addHeader("Cache-Control", "no-cache");
		     
				os = response.getOutputStream();
		       while ((index = input.read(bytes)) != -1) {
		    	   os.write(bytes, 0, index);
					os.flush();
				}
		       os.close();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询菜品信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/select.app", method = RequestMethod.GET)
	@ResponseBody
	public String selectMenu_InfoApp(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		List<Menu_Info> list = menu_InfoApi.SelectMenu_Info();
		//String result = JSONHelper.toJSON(list);
		return JSONHelper.toJSON(list);
	}
}
