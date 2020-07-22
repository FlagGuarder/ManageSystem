package com.text_project.service.AddStudent;

import com.text_project.bean.Student;
import com.text_project.dao.StudentDao;
import com.text_project.util.ResultSet;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AddStudentServiceImp implements AddStudentService{

    @Resource
    private StudentDao studentDao;

    @Override
    public ResultSet addStudent(Student data) {
        ResultSet result=new ResultSet();
        if(data==null||data.getNumber()==null||data.getUserName()==null||data.getPassword()==null||data.getClassInfo()==null){
            result.initStatus("400");
        }
        int res=studentDao.addStudent(data);
        if(res==1){
            result.initStatus("200");
        }
        else {
            result.initStatus("500");
        }
        return result;
    }
}
