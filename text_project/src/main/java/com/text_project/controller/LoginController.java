package com.text_project.controller;

import com.alibaba.fastjson.JSONObject;
import com.text_project.bean.Student;
import com.text_project.service.Login.LoginService;
import com.text_project.util.ResultSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录页面处理器
 * @author peng
 */
@RestController
@Slf4j
@RequestMapping("/login")
public class LoginController {

    @Resource
    private LoginService service;

    @PostMapping
    public JSONObject handleLogin(@RequestBody Student data, HttpServletRequest request){
        ResultSet result=service.login(data,request);
        return result.getResult();
    }
}
