package com.text_project.dao;

import com.text_project.bean.Job;
import com.text_project.bean.PageInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobDao {

    int addJob(Job job);

    List<Job> init(PageInfo pageInfo);

    int deleteJobById(Job job);

    int updateById(Job job);

    List<Job> getJobList();


    int getCount();
}
