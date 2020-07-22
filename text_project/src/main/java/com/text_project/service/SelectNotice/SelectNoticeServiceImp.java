package com.text_project.service.SelectNotice;

import com.text_project.bean.Notice;
import com.text_project.dao.NoticeDao;
import com.text_project.util.ResultSet;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SelectNoticeServiceImp implements SelectNoticeService {

    @Resource
    private NoticeDao noticeDao;

    @Override
    public ResultSet getNotice() {
        ResultSet result=new ResultSet();
        Notice notice=noticeDao.getNotice();
        if(notice==null){
            result.initStatus("500");
        }
        else {
            result.initData("200",notice);
        }
        return result;
    }
}
