package com.text_project.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * this bean is map with employee_inf
 * @author peng
 */
@Component
@Setter
@Getter
public class Employee {

   private int id;

   private Department depart;

   private Job job;

   private String name;

   private String cardId;

   private String address;

   private String postCode;

   private String tel;

   private String phone;

   private String qqNumber;

   private String email;

   private int sex;

   private String party;

   private String birthday;

   private String race;

   private String education;

   private String speciality;

   private String hobby;

   private String remark;

   private String createDate;
}
