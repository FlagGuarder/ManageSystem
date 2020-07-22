package com.text_project.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.text_project.bean.Department;
import com.text_project.bean.PageInfo;
import com.text_project.service.SelectDepart.SelectDepartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 部门查询页面
 * @author peng
 */
@RestController
@Slf4j
@RequestMapping("/selectDepart")
public class SelectDepartController {

    @Resource
    private SelectDepartService service;

    /**
     * 初始化页面数据
     * @return
     */
    @PostMapping("/init")
    public JSONObject init(@RequestParam(value="page") int page,
                           @RequestParam(value="rows") int rows){
        PageInfo pageInfo=new PageInfo(page, rows);
        return service.init(pageInfo).getResult();
    }

    @PostMapping("/deleteDepart")
    public JSONObject deleteDepart(@RequestBody Department data){
        return service.deleteDepart(data).getResult();
    }

    @PostMapping("/updateDepart")
    public JSONObject updateDepart(@RequestBody Department data){
        return service.updateDepart(data).getResult();
    }
}
