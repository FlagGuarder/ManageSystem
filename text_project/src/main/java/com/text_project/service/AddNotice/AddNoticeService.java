package com.text_project.service.AddNotice;

import com.text_project.bean.Notice;
import com.text_project.util.ResultSet;

import javax.servlet.http.HttpServletRequest;

public interface AddNoticeService {

    ResultSet addNotice(Notice data, HttpServletRequest request);

}
