package com.text_project.service.AddJob;

import com.text_project.bean.Job;
import com.text_project.dao.JobDao;
import com.text_project.util.ResultSet;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AddJobServiceImp implements AddJobService{

    @Resource
    private JobDao jobDao;

    @Override
    public ResultSet addJob(Job job) {
        ResultSet result=new ResultSet();
        if(job==null||job.getName()==null||job.equals("")){
            result.initStatus("400");
            return result;
        }
        if(job.getRemark()==null){
            job.setRemark("");
        }
        int res=jobDao.addJob(job);
        if(res==1){
            result.initStatus("200");
        }
        else {
            result.initStatus("500");
        }
        return result;
    }
}
