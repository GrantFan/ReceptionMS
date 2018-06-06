package com.reception.guest.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.reception.dictionary.api.DictionaryTableService;
import com.reception.dictionary.model.DictionaryTableEntity;
import com.reception.guest.entity.Guest_Info;
import com.reception.guest.entity.ResponseResult;
import com.reception.guest.service.Guest_InfoService;
import com.reception.hotel.model.HotelInfoEntity;
import com.reception.operate_log.util.LogAnnotation;
import com.reception.util.JSONHelper;
import com.reception.util.poi.ImportExcelUtil;

/**
 * @author zhangwei
 * @description  宾客信息管理
 * @date created in 16:41 2018/4/13
 * @throws Exception
 */
@RestController
@RequestMapping(value="/guest", produces = "application/json; charset=utf-8")
public class Guest_InfoAction {

    private static final Logger log = LoggerFactory.getLogger(Guest_InfoAction.class);

	@Value("${spring.http.multipart.location}")
	private String location;
	
    
    @Autowired
    private Guest_InfoService guest_infoService;
    
    @Autowired
    private DictionaryTableService dictionaryTableServiceImpl;


    /**
     * 添加宾客信息
     * @param guest_info
     * @return
     */
    @LogAnnotation(module = "宾客信息",remark = "新增宾客信息")
    @RequestMapping(value = "/insert" , method =  RequestMethod.POST)
    public @ResponseBody int InsertGuest_Info(Guest_Info guest_info,HttpServletRequest request){
    	System.out.println(guest_info);
        return guest_infoService.InsertGuest_Info(guest_info);
    }

    /**
     * 更新宾客信息
     * @param guest_info
     * @return
     */
    @LogAnnotation(module = "宾客信息",remark = "修改宾客信息")
    @RequestMapping(value = "/update" , method =  RequestMethod.POST)
    public @ResponseBody int UpdateGuest_Info(Guest_Info guest_info,HttpServletRequest request){
    	return guest_infoService.UpdateGuest_Info(guest_info);
    }

    /**
     * 删除宾客信息
     * @param guest_name
     * @return
     */
    @LogAnnotation(module = "宾客信息",remark = "删除宾客信息")
    @RequestMapping(value = "/delete" , method =  RequestMethod.DELETE)
    public int DeleteGuest_Info(@RequestParam("id") int id){
        return guest_infoService.DeleteGuest_Info(id);
    }

    /**
     * 分页查询数据
     * @param pageNum
     * @param pageSize
     * @return
     */
//    @LogAnnotation(module = "宾客信息",remark = "查询宾客信息")
    @RequestMapping(value = "/select", method =  RequestMethod.GET)
    public @ResponseBody String SeleteGuest_Info(@RequestParam(value="pageNum")String pageNum,@RequestParam(value="pageSize")String pageSize){
        PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
    	List<Guest_Info> guest_infos = guest_infoService.SelectGuest_Infos();
    	PageInfo<Guest_Info> pageInfo = new PageInfo<Guest_Info>(guest_infos);
        return JSONHelper.toJSON(pageInfo);
    }

    /**
     * 根据宾客的id，查看宾客的详细信息
     * @param id
     * @return
     */
//    @LogAnnotation(module = "宾客信息",remark = "查询宾客信息")
    @RequestMapping(value="/selectById",method = RequestMethod.GET)
    public String SelectGuest_InfoById(@RequestParam(value="id")int id){
    	Guest_Info guest_info = guest_infoService.SelectGuest_InfoById(id);
    	return JSONHelper.toJSON(guest_info);
    }
    
    /**
     * 上传图片
     * @param id
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "/uploadImg" , method =  RequestMethod.POST)
    public @ResponseBody String uploadPicture(@RequestParam(value="file",required=false)MultipartFile file,
    HttpServletRequest request){

        File targetFile=null;
        String msg="";//返回存储路径
        int code=1;
        String fileName=file.getOriginalFilename();//获取文件名加后缀
        if(fileName!=null&&fileName!=""){ 
//        	String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() +"/views/upload/imgs/";//存储路径
//            String path = request.getSession().getServletContext().getRealPath("views/upload/imgs"); //文件存储位置
//            String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());//文件后缀
            fileName=new Date().getTime()+"_"+new Random().nextInt(1000)+".png";//新的文件名

            //先判断文件是否存在
            String fileAdd = "guestphoto";
            File file1 = new File(location + fileAdd);
            //如果文件夹不存在则创建    
            if(!file1 .exists()  && !file1 .isDirectory()){       
                file1 .mkdir();
            }
            targetFile = new File(file1, fileName);
//          targetFile = new File(path, fileName);
            try {
                file.transferTo(targetFile);
//              msg=returnUrl+fileName;
//                msg=returnUrl+fileAdd+"/"+fileName;
                msg = "../../guest/img/" +fileName;
                code=0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return JSONHelper.toJSON(ResponseResult.result(code, msg));
    }
    
  //通过图片名获取图片文件 返回到前台生成图片
  	@RequestMapping(value = "/img/{filePath}", method = RequestMethod.GET,produces = "*/*; charset=utf-8")
  	public void getImage(@PathVariable("filePath") String filePath, HttpServletResponse response) {
  		String fileAdd = "guestphoto/";
  		filePath = location + fileAdd + filePath + ".png";
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
    
    @RequestMapping(value = "/deleteImg" , method =  RequestMethod.POST)
    public @ResponseBody int deletePicture(){
        //contains
    	List<String> photoNames = new ArrayList<String>();
    	//查詢所有图片路径
    	List<String> urls = guest_infoService.selectUrl();
    	for (String url : urls) {
    		if(null != url && ! "".equals(url)){
    		photoNames.add(url.substring(url.lastIndexOf("/")+1,url.length()));
    		}
		}
    	//获取指定路径下的全部文件名 
    	File file = new File(location + "guestphoto");;
    	 String [] fileNames = file.list();
         for (String name : fileNames) {
 			if(!photoNames.contains(name)){
 				File f = new File(location + "guestphoto/" + name);
 				if(f.exists()){
 		    	     f.delete();
 		        }
 			}
 		}
         
         return 1;
    }
    
    /**
     * 导出数据
     * @param request
     * @param response
     * @param path
     * @return
     */
    @LogAnnotation(module = "宾客信息",remark = "导出宾客信息")
    @RequestMapping(value="/guest.xls", produces = "*/*; charset=utf-8")
	public @ResponseBody String export(HttpServletRequest request,HttpServletResponse response) {
		// 总行数
		long rowSize = PageHelper.count(() -> {
			guest_infoService.SelectGuest_Info();
		});
		// 将某列设为下拉列表
		Map<Integer, String[]> map = new HashMap<Integer, String[]>();
		DictionaryTableEntity dictionary = new DictionaryTableEntity();
		String str[] = {"dm_sex","dm_education","dm_nation"};
		for(int i=0 ;i<str.length;i++){
			dictionary.setTableName(str[i]);// 行政区
			List<DictionaryTableEntity> dicList = dictionaryTableServiceImpl.list(dictionary);
			List<String> areaList = new ArrayList<String>();
			for (DictionaryTableEntity dic : dicList) {
				areaList.add(dic.getName());
			}
			String[] area = areaList.toArray(new String[0]);
			if(str[i].equals("dm_sex")){
			     map.put(5, area);
			}else if(str[i].equals("dm_education")){
				 map.put(8, area);
			}else{
				 map.put(7, area);
			}
		}
		// 导出数据集合
		List<Guest_Info> list = guest_infoService.SelectGuest_Info();
		// 导出
		InputStream input = ImportExcelUtil.excelModelbyClass(Guest_Info.class, map, (int) rowSize, list);
		OutputStream os = null;
		String fileName;
		int index;
		byte[] bytes = new byte[1024];
		try {
			response.setContentType("application/octet-stream;charset=utf-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("宾客信息", "UTF-8")
			+ ".xls;filename*=UTF-8''" + URLEncoder.encode("宾客信息", "UTF-8") + ".xls");
			//fileName = java.net.URLEncoder.encode("guest", "gb2312");
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
			os.close();
			return "true";
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "false";
    }
    
    
    @RequestMapping(value = "/list.app", method =  RequestMethod.GET)
    public @ResponseBody String SeleteGuest_InfoApp(HttpServletResponse response){
    	response.setHeader("Access-Control-Allow-Origin", "*");
    	List<Guest_Info> guest_infos = guest_infoService.SelectGuest_Infos();
        return JSONHelper.toJSON(guest_infos);
    }
    /**
     * 根据宾客的id，查看宾客的详细信息
     * @param id
     * @return
     */
    @RequestMapping(value="/info/{id}.app",method = RequestMethod.GET)
    public @ResponseBody String SelectGuest_InfoByIdApp(@PathVariable("id")String id){
    	Guest_Info guest_info = guest_infoService.SelectGuest_InfoById(Integer.parseInt(id));
    	return JSONHelper.toJSON(guest_info);
    }
    
    
    /**
	 * 获取文件的路径
	 * @param url
	 * @param request
	 * @param response
	 * @return
	 */
	@LogAnnotation(module = "酒店信息",remark = "导入酒店信息")
	@RequestMapping(value = "upLoadFile", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String getFileUrl(@RequestParam(value = "file", required = false) MultipartFile file) {
		File f = new File(location+ file.getOriginalFilename());
		int count = 0;
		try {
			file.transferTo(f);
			InputStream in =   new FileInputStream(f);
			List<Guest_Info> list = ImportExcelUtil.importExcel(Guest_Info.class, in);
//			System.out.println(list.size());
			for(Guest_Info guest_info : list){
				guest_infoService.InsertGuest_Info(guest_info);
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
}
