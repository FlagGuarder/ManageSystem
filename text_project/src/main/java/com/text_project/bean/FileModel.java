package com.text_project.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.File;

/**
 * @author peng
 */
@Getter
@Setter
public class FileModel {

    private int id;

    /**
     * 文件实体
     */
    private File file;

    /**
     * 系统内唯一文件名
     */
    private String name;

    /**
     * 用户自定义文件名
     */
    private String customName;

    /**
     * 上传者
     */
    private String uploader;

    /**
     * 上传时间
     */
    private String time;
}
