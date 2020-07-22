package com.text_project.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Job {

    private int id;

    private String name;

    private String remark;

}
