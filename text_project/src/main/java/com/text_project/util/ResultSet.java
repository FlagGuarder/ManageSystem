package com.text_project.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.text_project.bean.Department;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.List;

@Getter
@Slf4j
public class ResultSet {

    private JSONObject result;

    public ResultSet(){
        result=new JSONObject();
    }

    /**
     * 初始化状态码
     * @param status
     */
    public void initStatus(String status){
        result.put("status", status);
    }

    /**
     * 初始化状态码以及返回数据
     * @param status
     * @param obj
     */
    public void initData(String status,Object obj){
        initStatus(status);
        if(obj instanceof List){
            List list=(List)obj;
            JSONArray array=new JSONArray();
            for(Object object:list){
                array.add(putObjectToJSON(object));
            }
            result.put("object",array);
        }
        else {
            result.put("object",putObjectToJSON(obj));
        }
    }

    public void formDisplayData(int total,List data){
        result.put("total",total);
        result.put("rows",data);
    }

    /**
     * 将单个Object放入json文件中
     * @param obj
     * @return
     */
    private JSONObject putObjectToJSON(Object obj){
        JSONObject result=new JSONObject();
        Field[] fields=obj.getClass().getDeclaredFields();
        for(Field field:fields){
            field.setAccessible(true);
            String fieldName=field.getType().getSimpleName();
            if(fieldName.equals("Department")||fieldName.equals("Job")){
                JSONObject tempJson=new JSONObject();
                try {
                    Object tempObject = field.get(obj);
                    Field[] tempFields=tempObject.getClass().getDeclaredFields();
                    for(Field tempField:tempFields){
                        tempField.setAccessible(true);
                        tempJson.put(tempField.getName(),tempField.get(tempObject));
                        tempField.setAccessible(false);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if(fieldName.equals("Department")){
                    result.put("depart",tempJson);
                }
                else {
                    result.put("job",tempJson);
                }
            }
            else {
                try {
                    result.put(field.getName(),field.get(obj));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            field.setAccessible(false);
        }
        return result;
    }

}
