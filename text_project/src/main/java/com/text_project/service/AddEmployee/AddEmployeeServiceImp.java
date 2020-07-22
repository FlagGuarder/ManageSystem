package com.text_project.service.AddEmployee;

import com.text_project.bean.Department;
import com.text_project.bean.Employee;
import com.text_project.bean.Job;
import com.text_project.dao.DepartmentDao;
import com.text_project.dao.EmployeeDao;
import com.text_project.dao.JobDao;
import com.text_project.util.CurrentTime;
import com.text_project.util.ResultSet;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddEmployeeServiceImp implements AddEmployeeService{

    @Resource
    private JobDao jobDao;

    @Resource
    private DepartmentDao departmentDao;

    @Resource
    private EmployeeDao employeeDao;

    @Override
    public ResultSet addEmployee(Employee data) {
        ResultSet result=new ResultSet();
        if(data==null||data.getName()==null){
            result.initStatus("400");
            return result;
        }
        data.setCreateDate(CurrentTime.getCurrentTime());
        int res=employeeDao.addEmployee(data);
        if(res==1){
            result.initStatus("200");
        }
        else {
            result.initStatus("500");
        }
        return result;
    }

    @Override
    public ResultSet initEducation() {
        ResultSet resultSet=new ResultSet();
        List<Employee> list=employeeDao.getEducationList();
        if(list==null){
            resultSet.initStatus("500");
        }
        else {
            resultSet.initData("200",list);
        }
        return resultSet;
    }

    @Override
    public ResultSet initJob() {
        ResultSet resultSet=new ResultSet();
        List<Job> list=jobDao.getJobList();
        if(list==null){
            resultSet.initStatus("500");
        }
        else {
            resultSet.initData("200",list);
        }
        return resultSet;
    }

    @Override
    public ResultSet initDept() {
        ResultSet resultSet=new ResultSet();
        List<Department> list=departmentDao.getDeptList();
        if(list==null){
            resultSet.initStatus("500");
        }
        else {
            resultSet.initData("200",list);
        }
        return resultSet;
    }

    @Override
    public ResultSet initParty() {
        ResultSet resultSet=new ResultSet();
        List<Employee> list=employeeDao.getPartyList();
        if(list==null){
            resultSet.initStatus("500");
        }
        else {
            resultSet.initData("200",list);
        }
        return resultSet;
    }
}
