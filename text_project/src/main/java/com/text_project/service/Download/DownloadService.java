package com.text_project.service.Download;

import com.text_project.bean.FileModel;
import com.text_project.bean.PageInfo;
import com.text_project.util.ResultSet;

import javax.servlet.http.HttpServletResponse;

public interface DownloadService {

    ResultSet initFiles(PageInfo pageInfo);

    void downloadFile(FileModel data, HttpServletResponse response);
}
