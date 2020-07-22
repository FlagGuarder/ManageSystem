package com.text_project.service.SelectUser;

import com.text_project.bean.PageInfo;
import com.text_project.bean.Student;
import com.text_project.dao.StudentDao;
import com.text_project.util.ResultSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class SelectUserServiceImp implements SelectUserService {

    @Resource
    private StudentDao studentDao;

    @Override
    public ResultSet selectUser(Student data, PageInfo pageInfo) {
        List<Student> resList=studentDao.selectStudent(pageInfo,data);
        ResultSet result=new ResultSet();
        result.formDisplayData(studentDao.getCount(data),resList);
        return result;
    }

    @Override
    public ResultSet deleteUser(Student data) {
        ResultSet result=new ResultSet();
        if(data==null||data.getId()==0){
            result.initStatus("400");
        }
        int res=studentDao.deleteStudentById(data);
        if(res==1){
            result.initStatus("200");
        }
        else {
            result.initStatus("500");
        }
        return result;
    }

    @Override
    public ResultSet updateUser(Student data) {
        log.info(data.getNumber());
        log.info(data.getUserName());
        log.info(data.getPassword());
        log.info(data.getClassInfo());
        ResultSet result=new ResultSet();
        if(data==null||data.getNumber()==null||data.getNumber().equals("")){
            result.initStatus("400");
        }
        int res=studentDao.updateStudentByNumber(data);
        if(res==1){
            result.initStatus("200");
        }
        else {
            result.initStatus("500");
        }
        return result;
    }
}
