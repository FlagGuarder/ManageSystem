package com.text_project.service.SelectUser;


import com.text_project.bean.PageInfo;
import com.text_project.bean.Student;
import com.text_project.util.ResultSet;

public interface SelectUserService {

    ResultSet selectUser(Student data, PageInfo pageInfo);

    ResultSet deleteUser(Student data);

    ResultSet updateUser(Student data);
}
