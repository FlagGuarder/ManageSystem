package com.text_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @GetMapping("/login")
    public ModelAndView getLogin(){
        ModelAndView view=new ModelAndView();
        view.setViewName("login");
        return view;
    }

    @GetMapping("/selectUser")
    public ModelAndView getSelectUser(){
        ModelAndView view=new ModelAndView();
        view.setViewName("select_user");
        return view;
    }

    @GetMapping("/main")
    public ModelAndView getMain(){
        ModelAndView view=new ModelAndView();
        view.setViewName("main");
        return view;
    }

    @GetMapping("/addStudent")
    public ModelAndView getAddStudent(){
        ModelAndView view=new ModelAndView();
        view.setViewName("add_student");
        return view;
    }

    @GetMapping("/selectDepart")
    public ModelAndView getSelectDepart(){
        ModelAndView view=new ModelAndView();
        view.setViewName("select_department");
        return view;
    }

    @GetMapping("/addDepart")
    public ModelAndView getAddDepart(){
        ModelAndView view=new ModelAndView();
        view.setViewName("add_department");
        return view;
    }

    @GetMapping("/selectJob")
    public ModelAndView getSelectJob(){
        ModelAndView view=new ModelAndView();
        view.setViewName("select_job");
        return view;
    }

    @GetMapping("/addJob")
    public ModelAndView getAddJob(){
        ModelAndView view=new ModelAndView();
        view.setViewName("add_job");
        return view;
    }

    @GetMapping("/selectEmployee")
    public ModelAndView getSelectEmploee(){
        ModelAndView view=new ModelAndView();
        view.setViewName("select_employee");
        return view;
    }

    @GetMapping("/addEmployee")
    public ModelAndView getAddEmployee(){
        ModelAndView view=new ModelAndView();
        view.setViewName("add_employee");
        return view;
    }

    @GetMapping("/addNotice")
    public ModelAndView getAddNotice(){
        ModelAndView view=new ModelAndView();
        view.setViewName("add_notice");
        return view;
    }

    @GetMapping("/selectNotice")
    public ModelAndView getSelectNotice(){
        ModelAndView view=new ModelAndView();
        view.setViewName("select_notice");
        return view;
    }

    @GetMapping("/uploadFile")
    public ModelAndView getUploadFile(){
        ModelAndView view=new ModelAndView();
        view.setViewName("upload_file");
        return view;
    }

    @GetMapping("/downloadFile")
    public ModelAndView getDownloadFile(){
        ModelAndView view=new ModelAndView();
        view.setViewName("download_file");
        return view;
    }

    @GetMapping("/text")
    public ModelAndView getText(){
        ModelAndView view=new ModelAndView();
        view.setViewName("text");
        return view;
    }
}
