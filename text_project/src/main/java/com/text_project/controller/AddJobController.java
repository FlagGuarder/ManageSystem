package com.text_project.controller;

import com.alibaba.fastjson.JSONObject;
import com.text_project.bean.Job;
import com.text_project.service.AddJob.AddJobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/addJob")
public class AddJobController {

    @Resource
    private AddJobService service;

    @PostMapping("/add")
    public JSONObject addJob(@RequestBody Job job){
        return service.addJob(job).getResult();
    }
}
