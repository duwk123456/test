package com.xsd.portalmgr.util;   

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class GsonTools {
	
	private static final Gson gson = new Gson();
	
	
	/**
	 * @param <T>
	 * @param jsonString
	 * @param cls
	 * @return
	 */
	public static <T> T getObject(String jsonString, Class<T> cls) {
		T t = null;
		try {
			t = gson.fromJson(jsonString, cls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	
	
	public static void writeJsonObj(HttpServletResponse response,Object obj){
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("text/json;charset=UTF-8");
		String jsonStr = "";
		if (obj != null) {
			try {
				jsonStr = getJson(obj);
				response.getWriter().write(jsonStr);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	

	/**
	 * @param jsonString
	 * @return
	 */
	public static List<String> getList(String jsonString) {
		List<String> list = new ArrayList<String>();
		try {
			list = gson.fromJson(jsonString, new TypeToken<List<String>>() {
			}.getType());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<Map<String, Object>> listKeyMaps(String jsonString) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			list = gson.fromJson(jsonString,
					new TypeToken<List<Map<String, Object>>>() {
					}.getType());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static Map<String, Object> keyMaps(String jsonString) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		try {
			hashMap = gson.fromJson(jsonString,
					new TypeToken<Map<String, Object>>() {
					}.getType());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hashMap;
	}
	
	/**
	 * 对象转成json字符串
	 * @param object
	 * @return
	 */
	public  static String getJson(Object object){
		return gson.toJson(object);
	}
}
  