package com.text_project.dao;

import com.text_project.bean.PageInfo;
import com.text_project.bean.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {

    Student login(Student student);

    List<Student> selectStudentByCondition(Student student);

    int deleteStudentById(Student student);

    int updateStudentByNumber(Student student);

    int addStudent(Student student);

    List<Student> selectStudent(@Param(value = "pageInfo")PageInfo pageInfo, @Param(value = "student") Student student);

    /**
     * 获取符合条件的结果集大小
     * @param student
     * @return
     */
    int getCount(Student student);
}
