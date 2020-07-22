package com.text_project.util;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 返回当前时间
 * @author peng
 */
public class CurrentTime {

    public static String getCurrentTime(){
        LocalTime localTime=LocalTime.now();
        LocalDate localDate=LocalDate.now   ();
        StringBuffer buffer=new StringBuffer(localDate.toString());
        String time=localTime.toString();
        buffer.append(" ").append(time.substring(0,time.indexOf('.')));
        return buffer.toString();
    }
}
