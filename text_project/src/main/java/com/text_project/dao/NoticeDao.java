package com.text_project.dao;

import com.text_project.bean.Notice;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeDao {

    int addNotice(Notice data);

    int deleteAllNotice();

    Notice getNotice();
}
