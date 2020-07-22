package com.text_project.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * this bean is for save user Information
 * @author peng
 */
@Setter
@Getter
public class Student {

    private int id;

    private String number;

    private String userName;

    private String password;

    private String classInfo;

    private String remark;

}
