package com.reception.hotel.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
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

	@Value("${hotelphotoPath}")
    private String hotelphotoPath;
    
	@Resource
	private Hotel_graphService hotel_graphservice;

	
	 /**
     * 上传图片
     * @param id
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "/uploadImg" , method =  RequestMethod.POST)
    public @ResponseBody String uploadPicture(@RequestParam(value="file",required=false)MultipartFile file,@RequestParam("graph_name")String graph_name,@RequestParam("hotel")String hotel,
    HttpServletRequest request){
    	Hotel_graph hotel_graph = new Hotel_graph();
        File targetFile=null;
        String msg="";//返回存储路径
        int code=1;
        String fileName=file.getOriginalFilename();//获取文件名加后缀
        if(fileName!=null&&fileName!=""){ 
        	String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() +"/views/upload/imgs/";//存储路径
            String path = request.getSession().getServletContext().getRealPath("views/upload/imgs"); //文件存储位置
            String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());//文件后缀
            fileName=new Date().getTime()+"_"+new Random().nextInt(1000)+fileF;//新的文件名

            //先判断文件是否存在
            String fileAdd = "hotelphoto";
            File file1 =new File(path+"/"+fileAdd); 
            //如果文件夹不存在则创建    
            if(!file1 .exists()  && !file1 .isDirectory()){       
                file1 .mkdir();
            }
            targetFile = new File(file1, fileName);
            try {
                file.transferTo(targetFile);
                msg=returnUrl+fileAdd+"/"+fileName;
                code=0;
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
     * @param id
     * @return
     */
    @RequestMapping(value="/deleetImpById",method = RequestMethod.GET)
	public @ResponseBody int deleteImg(@RequestParam("id")String id){
    	int num = hotel_graphservice.deleteHotel_graph(id);
    	deletePicture();
		return num;
	}
    
    /**
     * 更具id删除图片信息
     * @param id
     * @return
     */
    @RequestMapping(value="/deleetImpByHotel",method = RequestMethod.GET)
	public @ResponseBody int deleteImgByHotel(@RequestParam("hotel")String hotel){
    	int num = hotel_graphservice.deleteHotel_graphByHotel(hotel);
    	deletePicture();
		return num;
	}
    
    /**
     * 根据酒店，查询其对应的图片信息
     * @param hotel
     * @return
     */
    @RequestMapping(value="/selectImpByHotel",method = RequestMethod.GET)
    public String selectHotel_graphByHotel(@RequestParam("hotel")String hotel){
		List<Hotel_graph> list = hotel_graphservice.selectHotel_graphByHotel(hotel);
		return JSONHelper.toJSON(list);

    }
    
    /**
     * 删除图片
     * @return
     */
    public void deletePicture(){
        //contains
    	List<String> photoNames = new ArrayList<String>();
    	//查詢所有图片路径
    	List<String> urls = hotel_graphservice.selectGraph_url();
    	for (String url : urls) {
    		if(null != url && ! "".equals(url)){
    		photoNames.add(url.substring(url.lastIndexOf("/")+1));
    		}
		}
    	//获取指定路径下的全部文件名 
    	File file = new File(hotelphotoPath);
    	 String [] fileNames = file.list();
    	 if(null != fileNames){
         for (String name : fileNames) {
 			if(!photoNames.contains(name)){
 				File f = new File(hotelphotoPath+name);
 				if(f.exists()){
 		    	     f.delete();
 		        }
 			}
 		}
      }
    }

}
