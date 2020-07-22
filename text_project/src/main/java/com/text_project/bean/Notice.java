package com.text_project.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class Notice {

    private int id;

    private String name;

    private String title;

    private String time;

    private String stuName;

    private String content;

}
