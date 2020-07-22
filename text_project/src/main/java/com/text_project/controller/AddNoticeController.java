package com.text_project.controller;

import com.alibaba.fastjson.JSONObject;
import com.text_project.bean.Notice;
import com.text_project.service.AddNotice.AddNoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;

@RestController
@Slf4j
@RequestMapping("/addNotice")
public class AddNoticeController {

    @Resource
    private AddNoticeService service;

    @PostMapping("/add")
    public JSONObject addObject(@RequestBody Notice data, HttpServletRequest request){

        return service.addNotice(data,request).getResult();
    }
}
