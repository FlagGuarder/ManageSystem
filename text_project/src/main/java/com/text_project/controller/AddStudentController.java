package com.text_project.controller;

import com.alibaba.fastjson.JSONObject;
import com.text_project.bean.Student;
import com.text_project.service.AddStudent.AddStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 添加用户界面
 * @author peng
 */
@RestController
@Slf4j
@RequestMapping("/addStudent")
public class AddStudentController {

    @Resource
    private AddStudentService service;

    @PostMapping("/add")
    public JSONObject addStudent(@RequestBody Student data){
        return service.addStudent(data).getResult();
    }
}
