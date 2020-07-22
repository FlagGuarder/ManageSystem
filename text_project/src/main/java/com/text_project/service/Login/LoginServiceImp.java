package com.text_project.service.Login;

import com.text_project.bean.Student;
import com.text_project.dao.StudentDao;
import com.text_project.util.ResultSet;
import com.text_project.util.SessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;

@Service
@Slf4j
public class LoginServiceImp implements LoginService {

    @Resource
    private StudentDao studentDao;

    @Override
    public ResultSet login(Student student, HttpServletRequest request) {
        ResultSet result=new ResultSet();
        if(student==null||student.getNumber()==null||student.getPassword()==null){
            result.initStatus("400");
        }
        Student res=studentDao.login(student);
        if(res==null){
            result.initStatus("400");
        }
        else {
            result.initData("200",res);
            SessionUtil.writeSession(request,res);
        }
        return result;
    }

}
