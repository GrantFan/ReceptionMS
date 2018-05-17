package com.reception.util.poi;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;

/**
 * @Description
 * @author zhaomin E-mail:min.zhao@mljr.com
 * @date 创建时间：2017年2月14日 下午2:13:30
 * @version 1.0
 */
public class ImportExcelUtil {
	final static String notnullerror = "请填入第{0}行的{1},{2}不能为空";
	final static String errormsg = "第{0}行的{1}数据导入错误";

	/**
	 * 导入Excel
	 * 
	 * @param clazz
	 * @param xls
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static List importExcel(Class<?> clazz, InputStream xls) throws Exception {
		try {
			// 取得Excel
			HSSFWorkbook wb = new HSSFWorkbook(xls);
			HSSFSheet sheet = wb.getSheetAt(0);
			HSSFCell cell = null;
			Object object = null;
			int rowSize = 0;
			Field[] fields = clazz.getDeclaredFields();
			List<Object> list = new ArrayList<>();
			// 第一行为标题，不取
			for (int rowIndex = 2; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
				HSSFRow row = sheet.getRow(rowIndex);
				if (row == null) {
					continue;
				}
				int tempRowSize = row.getLastCellNum() + 1;
				if (tempRowSize > rowSize) {
					rowSize = tempRowSize;
				}
				boolean hasValue = false;
				Object obj = clazz.newInstance();
				for (short columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++) {
					String value = "";

					cell = row.getCell(columnIndex);
					if (cell != null) {
						// 注意：一定要设成这个，否则可能会出现乱码
						// cell.setEncoding(HSSFCell.ENCODING_UTF_16);
						switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_STRING:
							value = cell.getStringCellValue();
							break;
						case HSSFCell.CELL_TYPE_NUMERIC:
							if (HSSFDateUtil.isCellDateFormatted(cell)) {
								Date date = cell.getDateCellValue();
								if (date != null) {
									value = new SimpleDateFormat("yyyy-MM-dd").format(date);
								} else {
									value = "";
								}
							} else {
								value = new DecimalFormat("0").format(cell.getNumericCellValue());
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
							value = (cell.getBooleanCellValue() == true ? "Y" : "N");
							break;
						default:
							value = "";
						}
					}
					if (columnIndex == 0 && value.trim().equals("")) {
						break;
					}
					//实体字段和表格别做匹配 然后给实体字段赋值
					for (Field field : fields) {
						if (field.isAnnotationPresent(ModelProp.class)) {
							ModelProp modelProp = field.getAnnotation(ModelProp.class);
							String filedName = field.getName();
							if (modelProp.colIndex() == (columnIndex)) {//实体字段注解colIndex列值
								field.setAccessible(true);
								field.set(obj, rightTrim(value));
							}
						}
					}
					object = obj;
				}
				list.add(object);
			}

			return list;

		} finally {
			xls.close();
		}
	}

	private final static int colsizeN = 630;
	private final static int colsizeM = 1000;

	/**
	 * 下载Excel模版
	 * 
	 * @param clazz
	 * @param map
	 * @param rowSize
	 * @return
	 */
	public static InputStream excelModelbyClass(Class<?> clazz, Map<Integer, String[]> map, Integer rowSize,
			List<?> list) {
		try {
			if (!clazz.isAnnotationPresent(ModelTitle.class)) {
				throw new Exception("请在此类型中加上ModelTitle注解");
			}
			if (rowSize == null) {
				rowSize = 1000;
			}
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet();
			/**
			 * 设置标题样式
			 */
			HSSFCellStyle titleStyle = wb.createCellStyle();
			titleStyle.setAlignment(HorizontalAlignment.CENTER_SELECTION);

			HSSFFont font = wb.createFont();
			font.setBold(true);
			font.setFontHeight((short) 400);
			titleStyle.setFont(font);
			HSSFCell titleCell = sheet.createRow(0).createCell(0); // 创建第一行，并在该行创建单元格，设置内容，做为标题行
			/**
			 * 获取标题
			 */
			ModelTitle modelTitle = clazz.getAnnotation(ModelTitle.class);
			titleCell.setCellValue(new HSSFRichTextString(modelTitle.name()));
			titleCell.setCellStyle(titleStyle);

			Field[] fields = clazz.getDeclaredFields();
			HSSFRow headRow = sheet.createRow(1);
			int colSzie = 0;
			/**
			 * 设置表头样式
			 */
			HSSFCellStyle headStyle = wb.createCellStyle();
			headStyle.setAlignment(HorizontalAlignment.CENTER_SELECTION);
			HSSFFont headFont = wb.createFont();

			headFont.setBold(true);
			headFont.setFontHeight((short) 240);
			headStyle.setFont(headFont);
			List<Integer> cells = new ArrayList<Integer>();

			for (Field field : fields) {
				if (field.isAnnotationPresent(ModelProp.class)) {
					ModelProp modelProp = field.getAnnotation(ModelProp.class);
					if (modelProp.colIndex() == -1)
						continue;
					HSSFCell cell = headRow.createCell(modelProp.colIndex());
					cell.setCellValue(new HSSFRichTextString(modelProp.name()));
					cell.setCellStyle(headStyle);
					colSzie++;
					sheet.autoSizeColumn((short) modelProp.colIndex());
					sheet.setColumnWidth(modelProp.colIndex(), modelProp.name().length() * colsizeN + colsizeM);

					// 设置列为下拉框格式
					if (map != null && map.get(new Integer(modelProp.colIndex())) != null) {
						DVConstraint constraint = DVConstraint
								.createExplicitListConstraint(map.get(modelProp.colIndex()));
						CellRangeAddressList regions = new CellRangeAddressList(2, rowSize, modelProp.colIndex(),
								modelProp.colIndex());
						HSSFDataValidation dataValidation = new HSSFDataValidation(regions, constraint);
						sheet.addValidationData(dataValidation);
					}
				}
			}
			HSSFCellStyle cellStyle = wb.createCellStyle();
			HSSFDataFormat format = wb.createDataFormat();
			cellStyle.setDataFormat(format.getFormat("@"));
			for (int i = 2; i < rowSize; i++) {
				HSSFRow row = sheet.createRow(i);
				for (Integer integer : cells) {
					HSSFCell cell = row.createCell(integer);
					cell.setCellStyle(cellStyle);
				}
			}
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, colSzie - 1));
			if (map != null) {
				for (Integer colIndex : map.keySet()) {
					DVConstraint constraint = DVConstraint.createExplicitListConstraint(map.get(colIndex));
					CellRangeAddressList regions = new CellRangeAddressList(2, 1000, colIndex, colIndex);
					HSSFDataValidation dataValidation = new HSSFDataValidation(regions, constraint);
					sheet.addValidationData(dataValidation);
				}
			}

			int index = 0;

			if (list == null) {
				return null;
			}

			for (int i = 0, j = list.size(); i < j; i++) {
				clazz = list.get(i).getClass();
				HSSFRow row = sheet.createRow(2 + i);

				for (Field field : fields) {
					// 设置第一列为序号列
					// HSSFCell cell_index = row.createCell(0);
					// cell_index.setCellValue(String.valueOf(i+1));
					// cell_index.setCellStyle(cellStyle);
					if (field.isAnnotationPresent(ModelProp.class)) {
						index = field.getAnnotation(ModelProp.class).colIndex();
						if (index == -1) {
							continue;
						}
						HSSFCell cell = row.createCell(index);
						Method method = clazz.getDeclaredMethod("get" + change(field.getName()));
						cell.setCellValue(method.invoke(list.get(i), null) != null
								? method.invoke(list.get(i), null).toString() : "");
						cell.setCellStyle(cellStyle);
					}
				}
			}

			FileChannel outChannel = null;

			ByteArrayOutputStream os = new ByteArrayOutputStream();

			try {
				wb.write(os);
			} catch (IOException e) {
				e.printStackTrace();
			}

			byte[] b = os.toByteArray();

			ByteArrayInputStream in = new ByteArrayInputStream(b);
			return in;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static String parseString(HSSFCell cell) {
		return String.valueOf(cell).trim();
	}

	private static long parseDate(String dateString) throws ParseException {
		if (dateString.indexOf("/") == 4) {
			return new SimpleDateFormat("yyyy/MM/dd").parse(dateString).getTime();
		} else if (dateString.indexOf("-") == 4) {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dateString).getTime();
		} else if (dateString.indexOf("年") == 4) {
			return new SimpleDateFormat("yyyy年MM月dd").parse(dateString).getTime();
		} else if (dateString.length() == 8) {
			return new SimpleDateFormat("yyyyMMdd").parse(dateString).getTime();
		} else {
			return new Date().getTime();
		}
	}

	/**
	 * @param src
	 *            源字符串
	 * @return 字符串，将src的第一个字母转换为大写，src为空时返回null
	 */
	private static String change(String src) {
		if (src != null) {
			StringBuilder sb = new StringBuilder(src);
			sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
			if (src.length() > 1) {
				sb.setCharAt(1, Character.toLowerCase(sb.substring(1).charAt(0)));
			}
			return sb.toString();
		} else {
			return null;
		}
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

}