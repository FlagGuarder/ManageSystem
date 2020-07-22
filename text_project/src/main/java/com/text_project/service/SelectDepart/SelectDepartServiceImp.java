package com.text_project.service.SelectDepart;

import com.text_project.bean.Department;
import com.text_project.bean.PageInfo;
import com.text_project.dao.DepartmentDao;
import com.text_project.dao.EmployeeDao;
import com.text_project.util.ResultSet;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SelectDepartServiceImp implements SelectDepartService{

    @Resource
    private DepartmentDao departmentDao;

    @Resource
    private EmployeeDao employeeDao;

    @Override
    public ResultSet init(PageInfo pageInfo) {
        Department department=new Department();
        ResultSet result=new ResultSet();
        List<Department> res=departmentDao.getDepartByCondition(department,pageInfo);
        result.formDisplayData(departmentDao.getCount(department),res);
        return result;
    }

    @Override
    public ResultSet deleteDepart(Department data) {
        ResultSet result=new ResultSet();
        if(data==null||data.getId()==0){
            result.initStatus("400");
            return result;
        }
        employeeDao.setDefaultDepart(data.getId());
        if(departmentDao.deleteById(data)==1){
            result.initStatus("200");
        }
        else{
            result.initStatus("500");
        }
        return result;
    }

    @Override
    public ResultSet updateDepart(Department data) {
        ResultSet result=new ResultSet();
        if(data==null||data.getId()==0||data.getName()==null||data.getRemark()==null){
            result.initStatus("400");
            return result;
        }
        int res=departmentDao.updateById(data);
        if(res==1){
            result.initStatus("200");
        }
        else {
            result.initStatus("500");
        }
        return result;
    }
}
