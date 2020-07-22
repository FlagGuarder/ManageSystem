package com.text_project.service.UploadFile;

import com.text_project.util.ResultSet;

import javax.servlet.http.HttpServletRequest;

public interface UploadFileService {

    ResultSet uploadFile(HttpServletRequest request);

}
