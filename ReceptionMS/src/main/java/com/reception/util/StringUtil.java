package com.reception.util;

import com.google.gson.Gson;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class StringUtil {


    private static final DateFormat dateTimeFormat = DateFormat.getDateTimeInstance();

    /**
     * 格式化时间，yyyy-MM-dd HH:mm:ss
     * @param date 日期
     * @return String
     */
    public static String formatDateTime(Date date){
        return dateTimeFormat.format(date);
    }

    //object 转 str
    public static String objToStr(Object obj) {
        if (obj == null || "".equals(obj.toString().trim())) {
            return null;
        }
        return obj.toString();
    }
    //非空判断
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        }
        return false;
    }
    //
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
    //空格判断
    public static boolean isBlank(String str)
    {
        int strLen;
        if(str == null || (strLen = str.length()) == 0)
            return true;
        for(int i = 0; i < strLen; i++)
            if(!Character.isWhitespace(str.charAt(i)))
                return false;

        return true;
    }

    // object to json
    public static String objToJson(Object obj){
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        return json;
    }
    /**
     * 处理obj==null函数
     */
    public static String sNull(Object obj) {
        //当obj==null时，如果使用toString()，将会出错！
        return obj == null ? "" : obj.toString();
    }

    /*
     * 返回当前时间
     * */
    public static String getTime(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(System.currentTimeMillis());
    }

}
