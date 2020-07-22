package com.text_project.service.UploadFile;

//import com.sun.tools.javac.code.Symtab;
import com.text_project.bean.FileModel;
import com.text_project.dao.FileDao;
import com.text_project.util.CurrentTime;
import com.text_project.util.File.FileOperation;
import com.text_project.util.ResultSet;
import com.text_project.util.SessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
@Slf4j
public class UploadFileServiceImp implements UploadFileService {

    @Resource
    private FileOperation fileOperation;

    @Resource
    private FileDao fileDao;

    @Override
    public ResultSet uploadFile(HttpServletRequest request) {
        ResultSet result=new ResultSet();
        if(request==null){
            result.initStatus("200");
            return result;
        }
        MultipartHttpServletRequest multipartRequest=(MultipartHttpServletRequest) request;
        MultipartFile file=multipartRequest.getFile("file");
        String fileStoreResult=fileOperation.addFile(file);
        if(fileStoreResult==null){
            result.initStatus("500");
        }
        else {
            FileModel data=new FileModel();
            data.setCustomName(formCustomName(request,fileStoreResult));
            data.setName(fileStoreResult);

            /*System.out.println("*********************");
            System.out.println(data.getName());*/
            data.setUploader((String) SessionUtil.getValueFromSession(request,"userName"));
            data.setTime(CurrentTime.getCurrentTime());
            int res=fileDao.addFile(data);
            if(res==1){
                result.initStatus("200");
            }
            else {
                result.initStatus("400");
            }
        }
        return result;
    }

    /**
     * 为用户自定义文件名添加后缀
     * @param request
     * @param realName
     * @return
     */
    private String formCustomName(HttpServletRequest request,String realName){
        String customName=request.getParameter("customName");
        String type=realName.substring(realName.lastIndexOf("."));
        StringBuilder res=new StringBuilder();
        res.append(customName).append(type);
        return res.toString();
    }
}
