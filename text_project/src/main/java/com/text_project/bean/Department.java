package com.text_project.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class Department {

    private int id;

    private String name;

    private String remark;

}
