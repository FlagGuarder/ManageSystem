package com.text_project.service.SelectDepart;

import com.text_project.bean.Department;
import com.text_project.bean.PageInfo;
import com.text_project.util.ResultSet;

public interface SelectDepartService {

    ResultSet init(PageInfo pageInfo);

    ResultSet deleteDepart(Department data);

    ResultSet updateDepart(Department data);

}
