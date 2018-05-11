package com.reception.guest.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.DateUtil;
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
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.reception.dictionary.api.DictionaryTableService;
import com.reception.dictionary.model.DictionaryTableEntity;
import com.reception.guest.entity.Guest_Info;
import com.reception.guest.entity.ResponseResult;
import com.reception.guest.service.Guest_InfoService;
import com.reception.util.JSONHelper;
import com.reception.util.poi.ImportExcelUtil;
import com.reception.util.poi.ModelTitle;

/**
 * @author zhangwei
 * @description  宾客信息管理
 * @date created in 16:41 2018/4/13
 * @throws Exception
 */
@RestController
@RequestMapping("/guest")
public class Guest_InfoAction {

    private static final Logger log = LoggerFactory.getLogger(Guest_InfoAction.class);

    @Value("${photoPath}")
    private String photoPath;
    
    @Value("${filePath}")
    private String filePath;
    
    @Autowired
    private Guest_InfoService guest_infoService;
    
    @Autowired
    private DictionaryTableService dictionaryTableServiceImpl;


    /**
     * 添加宾客信息
     * @param guest_info
     * @return
     */
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
    @RequestMapping(value = "/update" , method =  RequestMethod.POST)
    public @ResponseBody int UpdateGuest_Info(Guest_Info guest_info,HttpServletRequest request){
    	return guest_infoService.UpdateGuest_Info(guest_info);
    }

    /**
     * 删除宾客信息
     * @param guest_name
     * @return
     */
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
    @RequestMapping(value = "/select", method =  RequestMethod.GET)
    public String SeleteGuest_Info(@RequestParam(value="pageNum")String pageNum,@RequestParam(value="pageSize")String pageSize){
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
        	//String returnUrl = "D://upload/imgs/";//存储路径
            //String path = "D://upload/imgs"; //文件存储位置
            //String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() +"/upload/imgs/";//存储路径
        	String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() +"/views/upload/imgs/";//存储路径
            String path = request.getSession().getServletContext().getRealPath("views/upload/imgs"); //文件存储位置
            String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());//文件后缀
            fileName=new Date().getTime()+"_"+new Random().nextInt(1000)+fileF;//新的文件名

            //先判断文件是否存在
            String fileAdd = "photo";
            File file1 =new File(path+"/"+fileAdd); 
            //如果文件夹不存在则创建    
            if(!file1 .exists()  && !file1 .isDirectory()){       
                file1 .mkdir();
            }
            targetFile = new File(file1, fileName);
//          targetFile = new File(path, fileName);
            try {
                file.transferTo(targetFile);
//              msg=returnUrl+fileName;
                msg=returnUrl+fileAdd+"/"+fileName;
                code=0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return JSONHelper.toJSON(ResponseResult.result(code, msg));
    }
    
    
    
    @RequestMapping(value = "/deleteImg" , method =  RequestMethod.POST)
    public @ResponseBody int deletePicture(){
        //contains
    	List<String> photoNames = new ArrayList<String>();
    	//查詢所有图片路径
    	List<String> urls = guest_infoService.selectUrl();
    	for (String url : urls) {
    		if(null != url && ! "".equals(url)){
    		photoNames.add(url.substring(url.lastIndexOf("/")+1));
    		}
		}
    	//获取指定路径下的全部文件名 
    	File file = new File(photoPath);
    	 String [] fileNames = file.list();
         for (String name : fileNames) {
 			if(!photoNames.contains(name)){
 				File f = new File(photoPath+name);
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
    @RequestMapping(value="/guest.xls")
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
			fileName = java.net.URLEncoder.encode("guest", "gb2312");
			response.setContentType("application/octet-stream;charset=gb2312");
			// 设置title
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xls");
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
}
