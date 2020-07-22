package com.text_project.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.text_project.bean.Job;
import com.text_project.bean.PageInfo;
import com.text_project.service.SelectJob.SelectJobService;
import com.text_project.util.ResultSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/selectJob")
public class SelectJobController {

    @Resource
    private SelectJobService service;

    @PostMapping("/init")
    public JSONObject init(@RequestParam(value="page", required=false) int page,
                           @RequestParam(value="rows", required=false) int rows){
        PageInfo pageInfo=new PageInfo(page, rows);
        ResultSet result=service.init(pageInfo);
        return result.getResult();
    }

    @PostMapping("/deleteJob")
    public JSONObject delete(@RequestBody Job data){
        return service.deleteJob(data).getResult();
    }

    @PostMapping("/updateJob")
    public JSONObject update(@RequestBody Job data){
        return service.updateJob(data).getResult();
    }

}
