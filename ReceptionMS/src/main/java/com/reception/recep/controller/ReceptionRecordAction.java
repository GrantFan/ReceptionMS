package com.reception.recep.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.reception.hotel.model.HotelInfoEntity;
import com.reception.recep.api.AccommodationRecordService;
import com.reception.recep.api.MealsRecordService;
import com.reception.recep.model.AccommodationRecordEntity;
import com.reception.recep.model.MealsRecordEntity;
import com.reception.recep.model.ReceptionRecordEntity;
import com.reception.recep.service.ReceptionRecordServiceImpl;
import com.reception.util.JSONHelper;
import com.reception.util.poi.ImportExcelUtil;
import com.reception.util.poi.ModelTitle;

@RestController
@RequestMapping(value="/recep")
public class ReceptionRecordAction {

	@Resource
	ReceptionRecordServiceImpl receptionRecordServiceImpl;
	@Resource
	AccommodationRecordService accommodationRecordService;
	@Resource
	MealsRecordService mealsRecordService;
	
	@RequestMapping(value="/list",produces="application/text; charset=utf-8")
	public @ResponseBody String receptionRecordList(
			@RequestParam(value="pageSize",required = false,defaultValue = "5")String pageSize,
			@RequestParam(value="pageNum",required = false,defaultValue = "1")String pageNum){
		PageHelper.startPage(Integer.valueOf(pageNum), Integer.valueOf(pageSize));
		List<ReceptionRecordEntity> list = receptionRecordServiceImpl.selectList();
		PageInfo<ReceptionRecordEntity> pageInfo = new PageInfo<ReceptionRecordEntity>(list); 
		String json = JSONHelper.toJSON(pageInfo);
//		System.out.println(json);
		return json;
	}
	
	
	@RequestMapping(value="/search",produces="application/json; charset=utf-8")
	public @ResponseBody String receptionRecordSearch(
			@RequestParam(value="hotel")String hotel,
			@RequestParam(value="receptionTitle")String receptionTitle,
			@RequestParam(value="receptionDate")String receptionDate,
			@RequestParam(value="pageSize",required = false,defaultValue = "5")String pageSize,
			@RequestParam(value="pageNum",required = false,defaultValue = "1")String pageNum){
		ReceptionRecordEntity reception = new ReceptionRecordEntity();
		reception.setReceptionTitle(receptionTitle);
		reception.setReceptionDate(receptionDate);
		reception.setHotel(hotel);
		PageHelper.startPage(Integer.valueOf(pageNum), Integer.valueOf(pageSize));
		List<ReceptionRecordEntity> list = receptionRecordServiceImpl.selectLike(reception);
		PageInfo<ReceptionRecordEntity> pageInfo = new PageInfo<ReceptionRecordEntity>(list); 
		String json = JSONHelper.toJSON(pageInfo);
//		System.out.println(json);
		return json;
	}
	
	@RequestMapping(value="/recordInfo",produces="application/text; charset=utf-8")
	public @ResponseBody String receptionRecord(@RequestParam(value="receptionNumber")String receptionNumber){
		
		ReceptionRecordEntity reception = receptionRecordServiceImpl.selectByNumber(receptionNumber);
		List<AccommodationRecordEntity> acclist = accommodationRecordService.selectByReceptionNumber(receptionNumber);
		List<MealsRecordEntity> meallist = mealsRecordService.selectByReceptionNumber(receptionNumber);
		Map map = new HashMap<String, Object>();
		map.put("reception", reception);
		map.put("accommodation", acclist);
		map.put("meals", meallist);
		String json = JSONHelper.toJSON(map);
//		System.out.println(json);
		return json;
	}
	
	@RequestMapping(value = "/update", produces = "application/text; charset=utf-8")
	public String updateReceptionRecordInfo(ReceptionRecordEntity reception) {
		String flag = "false";
		int i = receptionRecordServiceImpl.update(reception);
		if (i > 0) {
			flag = "true";
		}
		return flag;
	};
	
	@RequestMapping(value = "/delete")
	public String deleteHotelInfo(@ModelAttribute("receptionRecordEntity") ReceptionRecordEntity reception) {
		String flag = "false";
		int i = receptionRecordServiceImpl.delete(reception);
		if (i > 0) {
			flag = "true";
		}
		return flag;
	};
	
	@RequestMapping(value = "/add", produces = "application/text; charset=utf-8")
	public String addReceptionRecordInfo(@RequestBody ReceptionRecordEntity reception) {
		ReceptionRecordEntity receptionNumber =receptionRecordServiceImpl.getReceptionNumber();
		reception.setReceptionNumber(receptionNumber.getReceptionNumber());
		System.out.println(reception.getReceptionNumber());
		String flag = "false";
		int i = receptionRecordServiceImpl.add(reception);
		if (i > 0) {
			flag = "true";
		}
		return flag;
	};
	
	@RequestMapping(value = "/export")
	public @ResponseBody String export(HttpServletResponse response) {
		OutputStream out = null;
		InputStream input = null;
		try {
			// 获得文件名
			ModelTitle modelTitle = ReceptionRecordEntity.class.getAnnotation(ModelTitle.class);
			String filename = modelTitle.name();
//			System.out.println(filename);
			// 总行数
			long rowSize = PageHelper.count(() -> {
				receptionRecordServiceImpl.selectList();
			});
			// System.out.println(rowSize);
			// 将某列设为下拉列表
			Map<Integer, String[]> map = new HashMap<Integer, String[]>();
//			DictionaryTableEntity dictionary = new DictionaryTableEntity();
//			dictionary.setTableName("dm_district");// 行政区
//			List<DictionaryTableEntity> dicList = dictionaryTableServiceImpl.list(dictionary);
//			List<String> areaList = new ArrayList<String>();
//			for (DictionaryTableEntity dic : dicList) {
//				areaList.add(dic.getName());
//			}
//			String[] area = areaList.toArray(new String[0]);
//			map.put(5, area);// 所属行政区下拉框
			// 导出数据集合
			List<ReceptionRecordEntity> list = receptionRecordServiceImpl.selectList();
			// 导出
			input = ImportExcelUtil.excelModelbyClass(ReceptionRecordEntity.class, map, (int) rowSize, list);
			int index;
			byte[] bytes = new byte[1024];

			response.setContentType("application/octet-stream;charset=utf-8");
			response.setHeader("Content-Disposition", "attachment;filename=" +URLEncoder.encode(filename,"UTF-8")+ ".xls;filename*=UTF-8''"+URLEncoder.encode(filename,"UTF-8")+".xls");
			response.addHeader("Pargam", "no-cache");
			response.addHeader("Cache-Control", "no-cache");

			out = response.getOutputStream();
			while ((index = input.read(bytes)) != -1) {
				out.write(bytes, 0, index);
				out.flush();
			}
			System.out.println(filename+"导出完成");
			return "true";
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (input != null) {
					input.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return "false";
	};
	
	
	
	@RequestMapping(value="/list.app",produces="application/json; charset=utf-8")
	public @ResponseBody String receptionRecordListApp(@RequestParam(value="receptionTitle",required = false,defaultValue = "")String receptionTitle,
													   @RequestParam(value="receptionDate",required = false,defaultValue = "")String receptionDate,
													   HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		ReceptionRecordEntity reception = new ReceptionRecordEntity();
		reception.setReceptionTitle(receptionTitle);
		reception.setReceptionDate(receptionDate);
		List<ReceptionRecordEntity> list = receptionRecordServiceImpl.selectLike(reception);
		String json = JSONHelper.toJSON(list);
		return json;
	}
	
	@RequestMapping(value="/info/{receptionNumber}.app", method = RequestMethod.GET,produces="application/json; charset=utf-8")
	public @ResponseBody String receptionRecordInfoApp(@PathVariable("receptionNumber")String receptionNumber,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		ReceptionRecordEntity recep = receptionRecordServiceImpl.selectByNumber(receptionNumber);
		String json = JSONHelper.toJSON(recep);
		return json;
	}
}
