package com.text_project.service.SelectEmployee;

import com.text_project.bean.Employee;
import com.text_project.bean.PageInfo;
import com.text_project.dao.EmployeeDao;
import com.text_project.service.SelectJob.SelectJobService;
import com.text_project.util.ResultSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class SelectEmployeeServiceImp implements SelectEmployeeService{

    @Resource
    private EmployeeDao employeeDao;

    @Override
    public ResultSet getEmployeeList(PageInfo pageInfo) {
        ResultSet result=new ResultSet();
        List<Employee> list=employeeDao.getEmployeeList(pageInfo);
        result.formDisplayData(employeeDao.getCount(),list);
        return result;
    }

    @Override
    public ResultSet deleteEmployee(Employee data) {
        ResultSet result=new ResultSet();
        if(data==null||data.getId()==0){
            result.initStatus("400");
            return result;
        }
        int res=employeeDao.deleteEmployee(data);
        if(res==1){
            result.initStatus("200");
        }
        else {
            result.initStatus("500");
        }
        return result;
    }

    @Override
    public ResultSet updateEmployee(Employee data) {
        ResultSet result=new ResultSet();
        if(data==null||data.getId()==0){
            result.initStatus("400");
            return result;
        }
        int res=employeeDao.updateEmployee(data);
        if(res==1){
            result.initStatus("200");
        }
        else {
            result.initStatus("500");
        }
        return result;
    }
}
