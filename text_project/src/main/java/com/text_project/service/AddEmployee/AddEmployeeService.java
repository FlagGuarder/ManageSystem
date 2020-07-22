package com.text_project.service.AddEmployee;

import com.text_project.bean.Employee;
import com.text_project.util.ResultSet;

import javax.annotation.Resource;

public interface AddEmployeeService {

    ResultSet initEducation();

    ResultSet initJob();

    ResultSet initDept();

    ResultSet initParty();

    ResultSet addEmployee(Employee data);
}
