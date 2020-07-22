package com.text_project.dao;

import com.text_project.bean.FileModel;
import com.text_project.bean.PageInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileDao {

    int addFile(FileModel data);

    List<FileModel> getFiles(PageInfo pageInfo);

    int getCount();
}
