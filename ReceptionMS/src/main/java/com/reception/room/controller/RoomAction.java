package com.reception.room.controller;

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
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.reception.dictionary.model.DictionaryTableEntity;
import com.reception.exceptionfilter.EntityNotFoundException;
import com.reception.hotel.model.HotelInfoEntity;
import com.reception.operate_log.util.LogAnnotation;
import com.reception.room.model.RoomInfoEntity;
import com.reception.room.service.RoomServiceImpl;
import com.reception.util.JSONHelper;
import com.reception.util.poi.ImportExcelUtil;
import com.reception.util.poi.ModelTitle;

@RestController
@RequestMapping(value = "/room")
public class RoomAction {

	@Value("${spring.http.multipart.location}")
    private String location;
	
	@Resource
	RoomServiceImpl roomServiceImpl;

	@RequestMapping(value="/add",produces="application/text; charset=utf-8")
	public @ResponseBody String addHotelInfo(RoomInfoEntity room) {
		String flag = "false";
		int i = roomServiceImpl.addRoomInfo(room);
		if(i>0){
			flag = "true";
		}
		return flag;
	};
	
	@RequestMapping(value="/batchadd",produces="application/text; charset=utf-8")
	public @ResponseBody String batchaddHotelInfo(RoomInfoEntity room) {
		String flag = "false";
		int count = Integer.parseInt(room.getRoomCount());
		for (int j = 0; j < count; j++) {
			roomServiceImpl.addRoomInfo(room);
		}
		flag = "true";
		return flag;
	};

	@RequestMapping(value="/update",produces="application/text; charset=utf-8")
	public String updateHotelInfo(RoomInfoEntity room) {
		String flag = "false";
		int i = roomServiceImpl.updateRoomInfo(room);
		if (i > 0) {
			flag = "true";
		}
		return flag;
	};

	@RequestMapping(value="/delete",produces="application/text; charset=utf-8")
	public String deleteHotelInfo(RoomInfoEntity room) {
		String flag = "false";
		int i = roomServiceImpl.deleteRoomInfo(room);
		if (i > 0) {
			flag = "true";
		}
		return flag;
	};

	@RequestMapping(value="/list",produces="application/text; charset=utf-8")
	public String selectList() {
		List<RoomInfoEntity> list = roomServiceImpl.selectList();
		JSONHelper jsonHelper = new JSONHelper();
		String json = jsonHelper.toJSON(list);
//		System.out.println(json);
		return json;
	};
	
	@RequestMapping(value="/listByHotel",produces="application/text; charset=utf-8")
	public String selectListByHotel(RoomInfoEntity room) {
		List<RoomInfoEntity> list = roomServiceImpl.selectListByHotel(room);
		JSONHelper jsonHelper = new JSONHelper();
		String json = jsonHelper.toJSON(list);
//		System.out.println(json);
		return json;
	};
	
	@RequestMapping(value="/floorList",produces="application/text; charset=utf-8")
	public String selectFloorByHotel(RoomInfoEntity room) {
		List<RoomInfoEntity> list = roomServiceImpl.selectFloorByHotel(room);
		JSONHelper jsonHelper = new JSONHelper();
		String json = jsonHelper.toJSON(list);
//		System.out.println(json);
		return json;
	};
	
	@RequestMapping(value="/floor",produces="application/text; charset=utf-8")
	public String selectFlooRoomrByHotel(RoomInfoEntity room) {
		List<RoomInfoEntity> list = roomServiceImpl.selectFlooRoomrByHotel(room);
		JSONHelper jsonHelper = new JSONHelper();
		String json = jsonHelper.toJSON(list);
//		System.out.println(json);
		return json;
	};
	
	@RequestMapping(value="/roomType",produces="application/text; charset=utf-8")
	public String selectByRoomType(String hotel_l,String hotel_r,String  roomType) {
		RoomInfoEntity room1 = new RoomInfoEntity();
		room1.setHotel(hotel_l);
		room1.setRoomType(roomType);
		List<RoomInfoEntity> list1 = roomServiceImpl.selectByRoomType(room1);
		
		RoomInfoEntity room2 = new RoomInfoEntity();
		room2.setHotel(hotel_r);
		room2.setRoomType(roomType);
		List<RoomInfoEntity> list2 = roomServiceImpl.selectByRoomType(room2);
		
		Map map = new HashMap<String, List>();
		map.put("hotel_l", list1);
		map.put("hotel_r", list2);
		String json = JSONHelper.toJSON(map);
//		System.out.println(json);
		return json;
	};
	
	@RequestMapping(value = "{id}",method = RequestMethod.GET)
	public String queryRoomById(@PathVariable("id")String id){
		RoomInfoEntity room =  this.roomServiceImpl.selectById(id);  
		if(room == null){
			new EntityNotFoundException("不存在"); 
		}
		return JSONHelper.toJSON(room);
	}
	
	@RequestMapping(value = "/export")
	public @ResponseBody String export(HttpServletResponse response) {
		OutputStream out = null;
		InputStream input = null;
		try {
			// 获得文件名
			ModelTitle modelTitle = RoomInfoEntity.class.getAnnotation(ModelTitle.class);
			String filename = modelTitle.name();
			
			// 总行数
			long rowSize = PageHelper.count(() -> {
				roomServiceImpl.selectList();
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
			List<RoomInfoEntity> list = roomServiceImpl.selectList();
			// 导出
			input = ImportExcelUtil.excelModelbyClass(RoomInfoEntity.class, map, (int) rowSize, list);
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
	
	@LogAnnotation(module = "房间信息",remark = "导入房间信息")
	@RequestMapping(value = "/import", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String getFileUrl(@RequestParam(value = "file", required = false) MultipartFile file) {
		File f = new File(location+ file.getOriginalFilename());
		InputStream in = null;
		int count = 0;
		try {
			file.transferTo(f);
			in = new FileInputStream(f);
			List<RoomInfoEntity> list = ImportExcelUtil.importExcel(RoomInfoEntity.class, in);
//			System.out.println(list.size());
			for(RoomInfoEntity room : list){
				roomServiceImpl.addRoomInfo(room);
				count++;
			}
			return "{\"flag\":\"true\",\"count\":\""+count+"\"}";
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"flag\":\"false\",\"count\":\""+count+"\"}";
		} finally {
			try {
				if(null != in){
					in.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (f.exists()) {
				f.delete();
			}
		}
	}
}
