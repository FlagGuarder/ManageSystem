package com.text_project.controller;

import com.alibaba.fastjson.JSONObject;
import com.text_project.util.SessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 主页处理器
 * @author peng
 */

@RestController
@RequestMapping("/main")
@Slf4j
public class MainController {


    @PostMapping("/init")
    public JSONObject init(HttpServletRequest request){
        JSONObject res=new JSONObject();
        res.put("status","200");
        JSONObject temp=new JSONObject();
        temp.put("userName", SessionUtil.getValueFromSession(request,"userName"));
        res.put("object",temp);
        return res;
    }

    @PostMapping("/logout")
    public JSONObject logout(HttpServletRequest request){
        JSONObject res=new JSONObject();
        res.put("status","200");
        JSONObject temp=new JSONObject();
        res.put("object",temp);
        SessionUtil.deleteSession(request);
        return res;
    }

}
