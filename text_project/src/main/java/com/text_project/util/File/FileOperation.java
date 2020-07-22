package com.text_project.util.File;

import com.text_project.bean.FileModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Component
@Slf4j
public class FileOperation {

    @Value("${resource.constant}")
    public String filePath;

    public String addFile(MultipartFile source){
        String originFileName=source.getOriginalFilename();// 文件原始名
        String fileType=originFileName.substring(originFileName.lastIndexOf('.'));   //获取文件类型
        String fileName=GetUUID.get();
        File des=new File(filePath+fileName+fileType);
        try {
            /*System.out.println(fileName);
            System.out.println("*********************");*/
            source.transferTo(des);
            return des.getName();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void downloadFile(HttpServletResponse response, FileModel fileModel){
        File file = new File("/Users/peng/"+fileModel.getName());


        try(FileInputStream inputStream = new FileInputStream(file)) {

            byte[] data = new byte[(int) file.length()];
            int length = inputStream.read(data);
            String fileName = URLEncoder.encode(fileModel.getCustomName(), "UTF-8");
            response.setContentType("application/octet-stream;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
            response.addHeader("Content-Length", "" + data.length);
            OutputStream stream = response.getOutputStream();
            stream.write(data);
            stream.flush();
        }catch (IOException e){
            e.printStackTrace();


        }
    }
}
