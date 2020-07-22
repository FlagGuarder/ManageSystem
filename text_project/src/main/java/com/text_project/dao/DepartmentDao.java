package com.text_project.dao;

import com.text_project.bean.Department;
import com.text_project.bean.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentDao {

    int addDepart(Department department);

    List<Department> getDepartByCondition(@Param(value = "department") Department department,@Param(value = "pageInfo") PageInfo pageInfo);

    int deleteById(Department department);

    int updateById(Department department);

    List<Department> getDeptList();

    int getCount(Department department);
}
