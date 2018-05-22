package com.reception.hotel.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.reception.guest.entity.ResponseResult;
import com.reception.hotel.api.Hotel_graphService;
import com.reception.hotel.model.Hotel_graph;
import com.reception.util.JSONHelper;

@RestController
@RequestMapping(value = "/hotel_graph")
public class Hotel_graphAction {

//	@Value("${hotelphotoPath}")
//	private String hotelphotoPath;

	@Value("${spring.http.multipart.location}")
	private String location;

	@Resource
	private Hotel_graphService hotel_graphservice;

	/**
	 * 上传图片
	 * 
	 * @param id
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
	public @ResponseBody String uploadPicture(@RequestParam(value = "file", required = false) MultipartFile file,
			@RequestParam("graph_name") String graph_name, @RequestParam("hotel") String hotel,
			HttpServletRequest request) {
		Hotel_graph hotel_graph = new Hotel_graph();
		File targetFile = null;
		String msg = "";// 返回存储路径
		int code = 1;
		String fileName = file.getOriginalFilename();// 获取文件名加后缀
		if (fileName != null && fileName != "") {
			// String returnUrl = request.getScheme() + "://" +
			// request.getServerName() + ":" + request.getServerPort() +
			// request.getContextPath() +"/views/upload/imgs/";//存储路径
			// String path =
			// request.getSession().getServletContext().getRealPath("views/upload/imgs");
			// //文件存储位置
//			String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());// 文件后缀
			fileName = new Date().getTime() + "_" + new Random().nextInt(1000) + ".png";// 新的文件名

			// 先判断文件是否存在
			String fileAdd = "hotelphoto";
			File file1 = new File(location + fileAdd);
			// 如果文件夹不存在则创建
			if (!file1.exists() && !file1.isDirectory()) {
				file1.mkdir();
			}
			targetFile = new File(file1, fileName);
			try {
				file.transferTo(targetFile);
				// msg=returnUrl+fileAdd+"/"+fileName;
				msg = fileName;
				code = 0;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		hotel_graph.setGraph_url(msg);
		hotel_graph.setGraph_name(graph_name);
		hotel_graph.setHotel(hotel);
		hotel_graphservice.addHotel_graph(hotel_graph);
		return JSONHelper.toJSON(ResponseResult.result(code, msg));
	}

	/**
	 * 更具id删除图片信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleetImpById", method = RequestMethod.GET)
	public @ResponseBody int deleteImg(@RequestParam("id") String id) {
		int num = hotel_graphservice.deleteHotel_graph(id);
		deletePicture();
		return num;
	}

	/**
	 * 更具id删除图片信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleetImpByHotel", method = RequestMethod.GET)
	public @ResponseBody int deleteImgByHotel(@RequestParam("hotel") String hotel) {
		int num = hotel_graphservice.deleteHotel_graphByHotel(hotel);
		deletePicture();
		return num;
	}

	/**
	 * 根据酒店，查询其对应的图片信息
	 * 
	 * @param hotel
	 * @return
	 */
	@RequestMapping(value = "/selectImpByHotel", method = RequestMethod.GET)
	public String selectHotel_graphByHotel(@RequestParam("hotel") String hotel) {
		List<Hotel_graph> list = hotel_graphservice.selectHotel_graphByHotel(hotel);
		for (Hotel_graph graph : list) {
			graph.setGraph_url("../../hotel_graph/img/" + graph.getGraph_url());//根据图片名拼一个返回图片的请求
		}
		// System.out.println(list);
		return JSONHelper.toJSON(list);

	}

	//通过图片名获取图片文件 返回到前台生成图片
	@RequestMapping(value = "/img/{filePath}", method = RequestMethod.GET)
	public void getImage(@PathVariable("filePath") String filePath, HttpServletResponse response) {
		String fileAdd = "hotelphoto/";
		filePath = location + fileAdd + filePath + ".png";;
		// System.out.println(filePath);
		FileInputStream fis = null;
		OutputStream out = null;
		try {
			File file = new File(filePath);
			fis = new FileInputStream(file);
			response.setContentType("image/jpg");
			int index;
			byte[] bytes = new byte[1024];
			out = response.getOutputStream();
			while ((index = fis.read(bytes)) != -1) {
				out.write(bytes, 0, index);
				out.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (null != fis) {
					fis.close();
				}
				if (null != out) {
					out.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 删除图片
	 * 
	 * @return
	 */
	public void deletePicture() {
		// contains
		List<String> photoNames = new ArrayList<String>();
		// 查詢所有图片路径
		List<String> urls = hotel_graphservice.selectGraph_url();
		for (String url : urls) {
			if (null != url && !"".equals(url)) {
				photoNames.add(url);
			}
		}
		// 获取指定路径下的全部文件名
		File file = new File(location + "hotelphoto");
		String[] fileNames = file.list();
		if (null != fileNames) {
			for (String name : fileNames) {
				if (!photoNames.contains(name)) {
					File f = new File(location + "hotelphoto/" + name);
					if (f.exists()) {
						f.delete();
					}
				}
			}
		}
	}

}
