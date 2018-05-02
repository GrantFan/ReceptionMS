package com.reception.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;



@Component
public class FileUtil {
 
	//获得配置的文件保存地址
	@Value("${spring.http.multipart.location}")
	String location ;

	/**
	 * 上传文件保存
	 * @param file 需要上传的文件
	 * @return 返回的文件路径
	 * @throws IOException 
	 */
	public  String getOneFilePath(MultipartFile file) throws IOException{

		String savePath = "";


		if(!file.isEmpty()){ 

			byte[] bytes = file.getBytes();
			//保存文件地址+文件名字 合成为 文家的URI
			Path path = Paths.get(location + file.getOriginalFilename());

			path = Files.write(path, bytes); 

			savePath = path.toString();
		}  
		return savePath;
	}

	/** 根据遍历目录下的文件名 来确认上传的文件是否重复
	 * @param file 上传的文件
	 * @return 返回boolean来确认
	 * 	 true 存在 false 不存在
	 * @throws IOException 
	 */
	public  boolean isFileExist(MultipartFile multipartFile) throws IOException{
		boolean flag = true;

		if(!multipartFile.isEmpty() && location != null){ 

			Path path = Paths.get(location+multipartFile.getOriginalFilename());

			flag = !Files.exists(path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});  
		} 
		return flag;
	}


}
