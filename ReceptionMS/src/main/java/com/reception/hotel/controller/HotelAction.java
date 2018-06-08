package com.reception.hotel.controller;

import java.io.File;
import java.io.FileInputStream;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.reception.dictionary.model.DictionaryTableEntity;
import com.reception.dictionary.service.DictionaryTableServiceImpl;
import com.reception.exceptionfilter.EntityNotFoundException;
import com.reception.hotel.model.HotelInfoEntity;
import com.reception.hotel.service.HotelServiceImpl;
import com.reception.operate_log.util.LogAnnotation;
import com.reception.util.JSONHelper;
import com.reception.util.poi.ImportExcelUtil;
import com.reception.util.poi.ModelTitle;

@RestController
@RequestMapping(value = "/hotel")
public class HotelAction {
	@Value("${spring.http.multipart.location}")
    private String location;
	
	@Resource
	HotelServiceImpl hotelServiceImpl;
	@Resource
	DictionaryTableServiceImpl dictionaryTableServiceImpl;

	@LogAnnotation(module = "酒店信息",remark = "添加酒店")
	@RequestMapping(value = "/add", produces = "application/text; charset=utf-8")
	public @ResponseBody String addHotelInfo(HotelInfoEntity hotel) {
		String flag = "false";
		int i = hotelServiceImpl.addHotelInfo(hotel);
		if (i > 0) {
			flag = "true";
		}
		return flag;
	};

	@LogAnnotation(module = "酒店信息",remark = "修改酒店信息")
	@RequestMapping(value = "/update", produces = "application/text; charset=utf-8")
	public String updateHotelInfo(HotelInfoEntity hotel) {
		String flag = "false";
		int i = hotelServiceImpl.updateHotelInfo(hotel);
		if (i > 0) {
			flag = "true";
		}
		return flag;
	};

	@LogAnnotation(module = "酒店信息",remark = "删除酒店")
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public String deleteHotelInfo(@ModelAttribute("hotelInfoEntity") HotelInfoEntity hotel) {
		String flag = "false";
		int i = hotelServiceImpl.deleteHotelInfo(hotel);
		if (i > 0) {
			flag = "true";
		}
		return flag;
	};

	@RequestMapping(value = "/list", produces = "application/text; charset=utf-8")
	public String selectList(@RequestParam(value = "pageNum", required = false, defaultValue = "1") String pageNum,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") String pageSize) {
		// long total = PageHelper.count(() ->
		// {hotelServiceImpl.selectList();});
		// Page page = PageHelper.getLocalPage();
		// 总页数
		// long totalPage = total / page.getPageSize() + ((total %
		// page.getPageSize() == 0) ? 0 : 1);
		PageHelper.startPage(Integer.valueOf(pageNum), Integer.valueOf(pageSize));
		List<HotelInfoEntity> list = hotelServiceImpl.selectList();
		PageInfo<HotelInfoEntity> pageInfo = new PageInfo<HotelInfoEntity>(list);
		String json = JSONHelper.toJSON(pageInfo);
		// System.out.println(json);
		return json;
	};

	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/text; charset=utf-8")
	public String queryHotelById(@PathVariable("id") String id) {
		HotelInfoEntity hotel = this.hotelServiceImpl.selectById(id);
		if (hotel == null) {
			new EntityNotFoundException("不存在");
		}
		return JSONHelper.toJSON(hotel);
	}

	@RequestMapping(value = "/listByName", produces = "application/text; charset=utf-8")
	public String selectListByName(HotelInfoEntity hotel) {
		List<HotelInfoEntity> list = hotelServiceImpl.selectListByName(hotel);
		String json = JSONHelper.toJSON(list);
		// System.out.println(json);
		return json;
	};

	@LogAnnotation(module = "酒店信息",remark = "导出酒店信息")
	@RequestMapping(value = "/export")
	public @ResponseBody String export(HttpServletResponse response) {
		OutputStream out = null;
		InputStream input = null;
		try {
			// 获得文件名
			ModelTitle modelTitle = HotelInfoEntity.class.getAnnotation(ModelTitle.class);
			String filename = modelTitle.name();
			System.out.println(filename);
			// 总行数
			long rowSize = PageHelper.count(() -> {
				hotelServiceImpl.selectList();
			});
			// System.out.println(rowSize);
			// 将某列设为下拉列表
			Map<Integer, String[]> map = new HashMap<Integer, String[]>();
			DictionaryTableEntity dictionary = new DictionaryTableEntity();
			dictionary.setTableName("dm_district");// 行政区
			List<DictionaryTableEntity> dicList = dictionaryTableServiceImpl.list(dictionary);
			List<String> areaList = new ArrayList<String>();
			for (DictionaryTableEntity dic : dicList) {
				areaList.add(dic.getName());
			}
			String[] area = areaList.toArray(new String[0]);
			map.put(5, area);// 所属行政区下拉框
			// 导出数据集合
			List<HotelInfoEntity> list = hotelServiceImpl.selectList();
			// 导出
			input = ImportExcelUtil.excelModelbyClass(HotelInfoEntity.class, map, (int) rowSize, list);

			response.setContentType("application/octet-stream;charset=utf-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8")
					+ ".xls;filename*=UTF-8''" + URLEncoder.encode(filename, "UTF-8") + ".xls");
			response.addHeader("Pargam", "no-cache");
			response.addHeader("Cache-Control", "no-cache");

			int index;
			byte[] bytes = new byte[1024];
			out = response.getOutputStream();
			while ((index = input.read(bytes)) != -1) {
				out.write(bytes, 0, index);
				out.flush();
			}
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

	@LogAnnotation(module = "酒店信息",remark = "导入酒店信息")
	@RequestMapping(value = "/import", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String getFileUrl(@RequestParam(value = "file", required = false) MultipartFile file) {
		File f = new File(location+ file.getOriginalFilename());
		int count = 0;
		try {
			file.transferTo(f);
			InputStream in =   new FileInputStream(f);
			List<HotelInfoEntity> list = ImportExcelUtil.importExcel(HotelInfoEntity.class, in);
//			System.out.println(list.size());
			for(HotelInfoEntity hotel : list){
				hotelServiceImpl.addHotelInfo(hotel);
				count++;
			}
			return "{\"flag\":\"true\",\"count\":\""+count+"\"}";
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"flag\":\"false\",\"count\":\""+count+"\"}";
		} finally {
			if (f.exists()) {
				f.delete();
			}
		}
	}

	@RequestMapping(value = "/info/{id}.app", method = RequestMethod.GET)
	public String queryHotelByIdApp(@PathVariable("id") String id,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		HotelInfoEntity hotel = this.hotelServiceImpl.selectById(id);
		if (hotel == null) {
			new EntityNotFoundException("不存在");
			return "";
		}
		return JSONHelper.toJSON(hotel);
	}

	@RequestMapping(value = "/list.app", produces = "application/json; charset=utf-8")
	public  String selectListByNameApp(HotelInfoEntity hotel,HttpServletResponse response) {
		// 指定允许其他域名访问    
		response.setHeader("Access-Control-Allow-Origin", "*");
//		// 响应类型    
//		response.setHeader("Access-Control-Allow-Methods","POST");    
//		// 响应头设置    
//		response.setHeader("Access-Control-Allow-Headers:x-requested-with","content-type");  
		
		List<HotelInfoEntity> list = hotelServiceImpl.selectListByName(hotel);
		String json = JSONHelper.toJSON(list);
//		 System.out.println(json);
		return json;
	};
	
	@RequestMapping(value = "/select.app", produces = "application/json; charset=utf-8")
	public  String selectList(HttpServletResponse response) {
		// 指定允许其他域名访问    
		response.setHeader("Access-Control-Allow-Origin", "*");
		List<HotelInfoEntity> list = hotelServiceImpl.selectList();
		String json = JSONHelper.toJSON(list);
		String str = json.replace("hotelName", "text");
//		System.out.println(str);
		return str;
	};
}
