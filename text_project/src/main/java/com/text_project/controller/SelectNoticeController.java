package com.text_project.controller;

import com.alibaba.fastjson.JSONObject;
import com.text_project.service.SelectNotice.SelectNoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/selectNotice")
public class SelectNoticeController {

    @Resource
    private SelectNoticeService service;

    @PostMapping("/getNotice")
    public JSONObject getNotice(){
        return service.getNotice().getResult();
    }
}
