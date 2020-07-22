package com.text_project.service.AddDepart;

import com.text_project.bean.Department;
import com.text_project.dao.DepartmentDao;
import com.text_project.util.ResultSet;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AddDepartServiceImp implements AddDepartService{

    @Resource
    private DepartmentDao departmentDao;

    @Override
    public ResultSet addDepart(Department data) {
        ResultSet result=new ResultSet();
        if(data==null||data.getName()==null||data.getName().equals("")){
            result.initStatus("400");
            return result;
        }
        if(data.getRemark()==null){
            data.setRemark("");
        }
        int res=departmentDao.addDepart(data);
        if(res==1){
            result.initStatus("200");
        }
        else {
            result.initStatus("500");
        }
        return result;
    }
}
