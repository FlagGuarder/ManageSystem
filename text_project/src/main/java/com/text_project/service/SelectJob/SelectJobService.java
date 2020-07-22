package com.text_project.service.SelectJob;

import com.text_project.bean.Job;
import com.text_project.bean.PageInfo;
import com.text_project.util.ResultSet;

public interface SelectJobService {

    ResultSet init(PageInfo info);

    ResultSet deleteJob(Job data);

    ResultSet updateJob(Job data);
}
