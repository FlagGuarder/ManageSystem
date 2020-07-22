package com.text_project.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.text_project.bean.FileModel;
import com.text_project.service.UploadFile.UploadFileService;
import com.text_project.util.ResultSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequestMapping("/uploadFile")
public class UploadFileController {

    @Resource
    private UploadFileService service;

    @PostMapping("/upload")
    public JSONObject upload(HttpServletRequest request){
        return service.uploadFile(request).getResult();
    }
}
