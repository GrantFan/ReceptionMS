package com.reception.recep.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.reception.recep.api.AccommodationRecordService;
import com.reception.recep.model.AccommodationRecordEntity;
import com.reception.recep.model.MealsRecordEntity;
import com.reception.recep.model.ReceptionRecordEntity;
import com.reception.util.JSONHelper;
import com.reception.util.poi.ImportExcelUtil;
import com.reception.util.poi.ModelTitle;

@RestController
@RequestMapping(value="/accom")
public class AccommodationRecordAction {
	@Resource
	AccommodationRecordService accommodationRecordService;
	
	@RequestMapping(value = "/update", produces = "application/text; charset=utf-8")
	public String updateReceptionRecordInfo(AccommodationRecordEntity accommodation) {
		String flag = "false";
		int i = accommodationRecordService.update(accommodation);
		if (i > 0) {
			flag = "true";
		}
		return flag;
	};
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public String deleteHotelInfo(@ModelAttribute("accommodationRecordEntity") AccommodationRecordEntity accommodation) {
		String flag = "false";
		int i = accommodationRecordService.delete(accommodation);
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
			ModelTitle modelTitle = AccommodationRecordEntity.class.getAnnotation(ModelTitle.class);
			String filename = modelTitle.name();
			// 总行数
			long rowSize = PageHelper.count(() -> {
				accommodationRecordService.selectList();
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
			List<AccommodationRecordEntity> list = accommodationRecordService.selectList();
			// 导出
			input = ImportExcelUtil.excelModelbyClass(AccommodationRecordEntity.class, map, (int) rowSize, list);
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
	
	@RequestMapping(value="/listByGuest",produces="application/json; charset=utf-8")
	public @ResponseBody String accomRecordListByGuest(String guestName){
		List<AccommodationRecordEntity> list = accommodationRecordService.selectByGuestName(guestName);
		String json = JSONHelper.toJSON(list);
		return json;
	}
	
	@RequestMapping(value="/list.app",produces="application/json; charset=utf-8")
	public @ResponseBody String accomRecordListApp(){
		List<AccommodationRecordEntity> list = accommodationRecordService.selectList();
		String json = JSONHelper.toJSON(list);
		return json;
	}
	
	@RequestMapping(value="/info/{id}.app", method = RequestMethod.GET,produces="application/json; charset=utf-8")
	public @ResponseBody String accomRecordInfoApp(@PathVariable("id")String id){
		AccommodationRecordEntity accom = accommodationRecordService.selectById(id);
		String json = JSONHelper.toJSON(accom);
		return json;
	}
}
