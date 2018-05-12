package com.reception.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.reception.guest.entity.Guest_Info;
import com.reception.guest.service.Guest_InfoService;

@RestController
@RequestMapping("/import")
public class BatchInputAction {
	
	 @Autowired
	 private Guest_InfoService guest_infoService;

	/**
	 * 获取文件的路径
	 * @param url
	 * @param request
	 * @param response
	 * @return
	 */
	  @RequestMapping(value="upLoadFile",method = RequestMethod.POST)
      public int getFileUrl(@RequestParam(value="file",required=false)MultipartFile file,HttpServletRequest request){
    	  //File file = new File(url);
		  File f = new File("E:/YLQHworkspace"+file.getOriginalFilename());
    	  try {
			file.transferTo(f);
			String[][] parms = getData(f,2);
			//批量插入宾客信息
			batchInputGuest(parms);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(f.exists()){
			f.delete();
			}
		}
    	  return 0;
      }
	  
	  
	  /**
		 * 读取Excel的内容，第一维数组存储的是一行中格列的值，二维数组存储的是多少个行
		 * 
		 * @param file
		 *            读取数据的源Excel
		 * @param ignoreRows
		 *            读取数据忽略的行数，比喻行头不需要读入 忽略的行数为1
		 * @return 读出的Excel中数据的内容
		 * @throws FileNotFoundException
		 * @throws IOException
		 */
		public static String[][] getData(File file, int ignoreRows)
				throws FileNotFoundException, IOException {
			List<String[]> result = new ArrayList<String[]>();
			int rowSize = 0;
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(
					file));
			// 打开HSSFWorkbook
			POIFSFileSystem fs = new POIFSFileSystem(in);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFCell cell = null;
			for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {
				HSSFSheet st = wb.getSheetAt(sheetIndex);
				// 第一行为标题，不取
				for (int rowIndex = ignoreRows; rowIndex <= st.getLastRowNum(); rowIndex++) {
					HSSFRow row = st.getRow(rowIndex);
					if (row == null) {
						continue;
					}
					int tempRowSize = row.getLastCellNum() + 1;
					if (tempRowSize > rowSize) {
						rowSize = tempRowSize;
					}
					String[] values = new String[rowSize];
					Arrays.fill(values, "");
					boolean hasValue = false;
					for (short columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++) {
						String value = "";
						cell = row.getCell(columnIndex);
						if (cell != null) {
							// 注意：一定要设成这个，否则可能会出现乱码
							//cell.setEncoding(HSSFCell.ENCODING_UTF_16);
							switch (cell.getCellType()) {
							case HSSFCell.CELL_TYPE_STRING:
								value = cell.getStringCellValue();
								break;
							case HSSFCell.CELL_TYPE_NUMERIC:
								if (HSSFDateUtil.isCellDateFormatted(cell)) {
									Date date = cell.getDateCellValue();
									if (date != null) {
										value = new SimpleDateFormat("yyyy-MM-dd")
												.format(date);
									} else {
										value = "";
									}
								} else {
									value = new DecimalFormat("0").format(cell
											.getNumericCellValue());
								}
								break;
							case HSSFCell.CELL_TYPE_FORMULA:
								// 导入时如果为公式生成的数据则无值
								if (!cell.getStringCellValue().equals("")) {
									value = cell.getStringCellValue();
								} else {
									value = cell.getNumericCellValue() + "";
								}
								break;
							case HSSFCell.CELL_TYPE_BLANK:
								break;
							case HSSFCell.CELL_TYPE_ERROR:
								value = "";
								break;
							case HSSFCell.CELL_TYPE_BOOLEAN:
								value = (cell.getBooleanCellValue() == true ? "Y"
										: "N");
								break;
							default:
								value = "";
							}
						}
						if (columnIndex == 0 && value.trim().equals("")) {
							break;
						}
						values[columnIndex] = rightTrim(value);
						hasValue = true;
					}

					if (hasValue) {
						result.add(values);
					}
				}
			}
			in.close();
			String[][] returnArray = new String[result.size()][rowSize];
			for (int i = 0; i < returnArray.length; i++) {
				returnArray[i] = (String[]) result.get(i);
			}
			return returnArray;
		}

		/**
		 * 去掉字符串右边的空格
		 * 
		 * @param str
		 *            要处理的字符串
		 * @return 处理后的字符串
		 */
		public static String rightTrim(String str) {
			if (str == null) {
				return "";
			}
			int length = str.length();
			for (int i = length - 1; i >= 0; i--) {
				if (str.charAt(i) != 0x20) {
					break;
				}
				length--;
			}
			return str.substring(0, length);
		}
		
		/**
		 * 批量导入宾客信息
		 * @param parms
		 */
		public void batchInputGuest(String[][] parms){
			 List<Guest_Info> guest_infos = new ArrayList<Guest_Info>();
			for(int i=0;i<parms.length;i++){
				Guest_Info guest_info = new Guest_Info();
				guest_info.setGuest_name(parms[i][0]);
				guest_info.setMain_position(parms[i][1]);
				guest_info.setDeputy_position(parms[i][2]);
				guest_info.setOffice_area(parms[i][3]);
				guest_info.setSex(parms[i][4]);
				guest_info.setBirth_date(parms[i][5]);
				guest_info.setNation(parms[i][6]);
				guest_info.setNation(parms[i][7]);
				guest_info.setOrigin_place(parms[i][8]);
				guest_info.setTelphone(parms[i][9]);
				guest_info.setPhone(parms[i][10]);
				guest_info.setEmail(parms[i][11]);
				guest_info.setAddress(parms[i][12]);
				guest_info.setGuest_type(parms[i][13]);
				guest_info.setRemark(parms[i][14]);
				guest_infos.add(guest_info);
		}
		for (int i = 0; i < guest_infos.size(); i++) {
			guest_infoService.InsertGuest_Info(guest_infos.get(i));
		  }
		}
}