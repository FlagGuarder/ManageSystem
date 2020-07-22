package com.text_project.controller;

import com.alibaba.fastjson.JSONObject;
import com.text_project.bean.Employee;
import com.text_project.service.AddEmployee.AddEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/addEmployee")
public class AddEmployeeController {

    @Resource
    private AddEmployeeService service;

    @PostMapping("/initEducation")
    public JSONObject initEducation(){
        //初始化学历列表
        return service.initEducation().getResult();
    }

    @PostMapping("/initJob")
    public JSONObject initJob(){
        //初始化工作列表
        return service.initJob().getResult();
    }

    @PostMapping("/initDept")
    public JSONObject initDept(){
        //初始化部门列表
        return service.initDept().getResult();
    }

    @PostMapping("/initParty")
    public JSONObject initParty(){
        return service.initParty().getResult();
    }

    @PostMapping("/addEmployee")
    public JSONObject addEmployee(@RequestBody Employee data){
        log.info(data.getDepart().getId()+"");
        log.info(data.getJob().getId()+"");
        return service.addEmployee(data).getResult();
    }
}
