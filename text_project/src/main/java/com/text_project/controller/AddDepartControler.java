package com.text_project.controller;

import com.alibaba.fastjson.JSONObject;
import com.text_project.bean.Department;
import com.text_project.service.AddDepart.AddDepartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/addDepart")
public class AddDepartControler {

    @Resource
    private AddDepartService service;

    @PostMapping("/add")
    public JSONObject add(@RequestBody Department data){
        return service.addDepart(data).getResult();
    }
}
