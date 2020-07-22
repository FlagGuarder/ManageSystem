package com.text_project.service.Download;

import com.text_project.bean.FileModel;
import com.text_project.bean.PageInfo;
import com.text_project.dao.FileDao;
import com.text_project.util.File.FileOperation;
import com.text_project.util.ResultSet;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class DownloadServiceImp implements DownloadService{

    @Resource
    private FileDao fileDao;

    @Resource
    private FileOperation fileOperation;

    @Override
    public ResultSet initFiles(PageInfo pageInfo) {
        ResultSet result=new ResultSet();
        List<FileModel> list=fileDao.getFiles(pageInfo);
        result.formDisplayData(fileDao.getCount(),list);
        return result;
    }

    @Override
    public void downloadFile(FileModel data, HttpServletResponse response) {
        fileOperation.downloadFile(response,data);
    }
}
