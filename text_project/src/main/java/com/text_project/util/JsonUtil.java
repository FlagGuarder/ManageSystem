package com.text_project.util;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;

/**
 * @author peng
 */
public class JsonUtil {

    public static void jsonToObject(Object obj,JSONObject source){
        Field[] fields=obj.getClass().getDeclaredFields();
        for(Field temp:fields){
            temp.setAccessible(true);
            try {
                temp.set(obj,source.getString(temp.getName()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            temp.setAccessible(false);
        }
    }


}
