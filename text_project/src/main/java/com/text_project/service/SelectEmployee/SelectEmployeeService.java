package com.text_project.service.SelectEmployee;

import com.text_project.bean.Employee;
import com.text_project.bean.PageInfo;
import com.text_project.util.ResultSet;

public interface SelectEmployeeService {

    ResultSet getEmployeeList(PageInfo pageInfo);

    ResultSet deleteEmployee(Employee data);

    ResultSet updateEmployee(Employee data);
}
