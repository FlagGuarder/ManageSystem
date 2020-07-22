package com.text_project.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;

/**
 * 操作session
 * @author peng
 * @version 1.0
 */
public class SessionUtil {

    /**
     * 写入session
     * @param request
     * @param data
     */
    public static void writeSession(HttpServletRequest request,Object data){
        if(data==null){
            return;
        }
        HttpSession session=request.getSession();
        session.setMaxInactiveInterval(60*60);
        Field[] fields=data.getClass().getDeclaredFields();
        for(Field field:fields){
            field.setAccessible(true);
            try {
                session.setAttribute(field.getName(),field.get(data));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } finally {
                field.setAccessible(false);
            }
        }
    }

    /**
     * 删除session，用于登出操作
     * @param request
     */
    public static void deleteSession(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.invalidate();
    }

    /**
     * 获取session缓存的值
     * @param request
     * @param key
     * @return
     */
    public static Object getValueFromSession(HttpServletRequest request,String key){
        if(key==null){
            return null;
        }
        HttpSession session=request.getSession();
        Object res=session.getAttribute(key);
        return res;
    }
}
