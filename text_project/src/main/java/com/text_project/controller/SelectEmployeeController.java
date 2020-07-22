package com.text_project.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.text_project.bean.Employee;
import com.text_project.bean.PageInfo;
import com.text_project.service.SelectEmployee.SelectEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/selectEmployee")
public class SelectEmployeeController {

    @Resource
    private SelectEmployeeService service;

    @RequestMapping("/init")
    public JSONObject init(@RequestParam(value="page") int page,
                           @RequestParam(value="rows") int rows){
        PageInfo pageInfo=new PageInfo(page,rows);
        return service.getEmployeeList(pageInfo).getResult();
    }

    @RequestMapping("/delete")
    public JSONObject delete(@RequestBody Employee data){
        return service.deleteEmployee(data).getResult();
    }

    @RequestMapping("/update")
    public JSONObject update(@RequestBody Employee data){
        return service.updateEmployee(data).getResult();
    }
}
