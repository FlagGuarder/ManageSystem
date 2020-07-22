package com.text_project.service.Login;



import com.text_project.bean.Student;
import com.text_project.util.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * this interface is defined a rule for handle login page event
 * @author peng
 */
public interface LoginService {

    ResultSet login(Student student, HttpServletRequest request);


}
