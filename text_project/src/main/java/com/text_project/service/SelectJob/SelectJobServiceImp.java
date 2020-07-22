package com.text_project.service.SelectJob;

import com.text_project.bean.Job;
import com.text_project.bean.PageInfo;
import com.text_project.dao.EmployeeDao;
import com.text_project.dao.JobDao;
import com.text_project.service.SelectDepart.SelectDepartService;
import com.text_project.util.ResultSet;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SelectJobServiceImp implements SelectJobService {

    @Resource
    private EmployeeDao employeeDao;

    @Resource
    private JobDao jobDao;

    @Override
    public ResultSet init(PageInfo pageInfo) {
        ResultSet result=new ResultSet();
        result.formDisplayData(jobDao.getCount(),jobDao.init(pageInfo));
        return result;
    }

    @Override
    public ResultSet deleteJob(Job data) {
        ResultSet result=new ResultSet();
        if(data==null||data.getId()==0){
            result.initStatus("400");
            return result;
        }
        employeeDao.setDefaultJob(data.getId());
        if(jobDao.deleteJobById(data)==1){
            result.initStatus("200");
        }
        else {
            result.initStatus("500");
        }
        return result;
    }

    @Override
    public ResultSet updateJob(Job data) {
        ResultSet result=new ResultSet();
        if(data==null||data.getId()==0){
            result.initStatus("400");
            return result;
        }
        if(jobDao.updateById(data)==1){
            result.initStatus("200");
        }
        else {
            result.initStatus("500");
        }
        return result;
    }
}
