package com.text_project.controller;

import com.alibaba.fastjson.JSONObject;
import com.text_project.bean.FileModel;
import com.text_project.bean.PageInfo;
import com.text_project.service.Download.DownloadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

@RestController
@Slf4j
@RequestMapping("/downloadFile")
public class DownloadController {

    @Resource
    private DownloadService service;

    @PostMapping("/getFiles")
    public JSONObject getFiles(@RequestParam(value="page") int page,
                               @RequestParam(value="rows") int rows){
        PageInfo pageInfo=new PageInfo(page, rows);
        return service.initFiles(pageInfo).getResult();
    }

    @RequestMapping("/download")
    public void downloadFile(@RequestParam("name") String name,@RequestParam("customName") String customName, HttpServletResponse response) {
        FileModel file=new FileModel();
        file.setName(name);
        file.setCustomName(customName);


        service.downloadFile(file,response);
    }
}
