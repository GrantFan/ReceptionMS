package com.reception.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;


public class JSONHelper {
    private static Gson gson = new GsonBuilder()
            .disableInnerClassSerialization()
            .serializeNulls()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    /**
     * json字符串转化为map
     * @param content json
     * @param classes 长度为2的 Class对象数组
     * @param <T> 泛型
     * @return
     */
    public static <T> T toMap(String content, Class[] classes) {
        Type mapType = new ParameterizedTypeImpl(Map.class, classes);
        return gson.fromJson(content, mapType);
    }

    public static <T> T toMap(String content, Gson gson, Class[] classes) {
        Type mapType = new ParameterizedTypeImpl(Map.class, classes);
        return gson.fromJson(content, mapType);
    }

    /**
     * json转化为对象
     * @param str json字符串
     * @param clazz 类型
     * @param <T> 泛型
     * @return
     */
    public static <T> T fromJsonObject(String str, Class<T> clazz) {
        Type type = new ParameterizedTypeImpl(clazz, new Class[]{clazz});
        return gson.fromJson(str, type);
    }


    public static <T> T fromJsonObject(String str, Class<T> clazz, Gson gson) {
        Type type = new ParameterizedTypeImpl(clazz, new Class[]{clazz});
        return gson.fromJson(str, type);
    }

    /**
     * json转化为对象
     * @param reader json结构的流
     * @param clazz 类型
     * @param <T> 泛型
     * @return
     */
    public static <T> T fromJsonObject(Reader reader, Class<T> clazz) {
        Type type = new ParameterizedTypeImpl(clazz, new Class[]{clazz});
        return gson.fromJson(reader, type);
    }

    public static <T> T fromJsonObject(Reader reader, Class<T> clazz, Gson gson) {
        Type type = new ParameterizedTypeImpl(clazz, new Class[]{clazz});
        return gson.fromJson(reader, type);
    }


    /**
     *
     * @param str
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> fromJsonArray(String str, Class<T> clazz) {
        // 生成List<T> 中的 List<T>
        Type listType = new ParameterizedTypeImpl(List.class, new Class[]{clazz});
        return gson.fromJson(str, listType);
    }

    public static <T> List<T> fromJsonArray(String str, Class<T> clazz, Gson gson) {
        // 生成List<T> 中的 List<T>
        Type listType = new ParameterizedTypeImpl(List.class, new Class[]{clazz});
        return gson.fromJson(str, listType);
    }

    /**
     *
     * @param reader
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> fromJsonArray(Reader reader, Class<T> clazz) {
        Type listType = new ParameterizedTypeImpl(List.class, new Class[]{clazz});
        return gson.fromJson(reader, listType);
    }

    public static <T> List<T> fromJsonArray(Reader reader, Class<T> clazz, Gson gson) {
        Type listType = new ParameterizedTypeImpl(List.class, new Class[]{clazz});
        return gson.fromJson(reader, listType);
    }


    /**
     * 对象转化为json字符串
     * @param obj 对象
     * @param type 类型
     * @return json
     */
    public static String toJSON(Object obj, Type type){
        return gson.toJson(obj, type);
    }

    /**
     * 对象转化为json字符串
     * @param obj 对象
     * @return json
     */
    public static String toJSON(Object obj){
        return gson.toJson(obj);
    }


    private static class ParameterizedTypeImpl implements ParameterizedType {
        private final Class raw;
        private final Type[] args;
        public ParameterizedTypeImpl(Class raw, Type[] args) {
            this.raw = raw;
            this.args = args != null ? args : new Type[0];
        }
        @Override
        public Type[] getActualTypeArguments() {
            return args;
        }
        @Override
        public Type getRawType() {
            return raw;
        }
        @Override
        public Type getOwnerType() {return null;}
    }


    private static Map testToMap(String src){
        Map<String, String> map = toMap(src, new Class[]{String.class, Object.class});
        return map;
    }

    public static void setGson(Gson gson) {
        JSONHelper.gson = gson;
    }
}
