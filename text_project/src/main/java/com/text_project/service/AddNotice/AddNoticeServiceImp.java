package com.text_project.service.AddNotice;

import com.text_project.bean.Notice;
import com.text_project.dao.NoticeDao;
import com.text_project.util.CurrentTime;
import com.text_project.util.ResultSet;
import com.text_project.util.SessionUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class AddNoticeServiceImp implements AddNoticeService{

    @Resource
    private NoticeDao noticeDao;

    @Override
    public ResultSet addNotice(Notice data, HttpServletRequest request) {
        ResultSet result=new ResultSet();
        if(data==null||data.getContent()==null||data.getContent().equals("")){
            result.initStatus("400");
            return result;
        }
        data.setStuName((String) SessionUtil.getValueFromSession(request,"userName"));

        data.setTime(CurrentTime.getCurrentTime());
        noticeDao.deleteAllNotice();
        int res=noticeDao.addNotice(data);
        if(res==1){
            result.initStatus("200");
        }
        else {
            result.initStatus("400");
        }
        return result;
    }

}
