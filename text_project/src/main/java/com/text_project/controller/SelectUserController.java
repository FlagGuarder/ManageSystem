package com.text_project.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.text_project.bean.PageInfo;
import com.text_project.bean.Student;
import com.text_project.service.SelectUser.SelectUserService;
import com.text_project.util.ResultSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户查询处理器
 * @author peng
 */

@RestController
@Slf4j
@RequestMapping("/selectUser")
public class SelectUserController {

    @Resource
    private SelectUserService service;

    @PostMapping
    public JSONObject getUser(@RequestParam(value="page") int page,
                              @RequestParam(value="rows") int rows,
                              @RequestParam(value = "number",required = false) String number,
                              @RequestParam(value = "userName",required = false) String userName,
                              @RequestParam(value = "classInfo",required = false) String classInfo){
        Student student=new Student();
        student.setNumber(number);
        student.setUserName(userName);
        student.setClassInfo(classInfo);
        PageInfo pageInfo=new PageInfo(page, rows);
        ResultSet result=service.selectUser(student,pageInfo);
        return result.getResult();
    }

    @PostMapping("/deleteUser")
    public JSONObject deleteUser(@RequestBody Student data){
        return service.deleteUser(data).getResult();
    }

    @PostMapping("/updateUser")
    public JSONObject updateUser(@RequestBody Student data){
        return service.updateUser(data).getResult();
    }
}
