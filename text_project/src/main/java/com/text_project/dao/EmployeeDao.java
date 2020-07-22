package com.text_project.dao;

import com.text_project.bean.Employee;
import com.text_project.bean.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao {

    List<Employee> getEducationList();

    List<Employee> getPartyList();

    int setDefaultDepart(@Param("departId") int departId);

    int setDefaultJob(@Param("jobId") int jobId);

    int addEmployee(Employee data);

    List<Employee> getEmployeeList(PageInfo pageInfo);

    int deleteEmployee(Employee data);

    int updateEmployee(Employee data);

    int getCount();
}
