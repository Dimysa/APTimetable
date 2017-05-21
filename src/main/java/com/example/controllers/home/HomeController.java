package com.example.controllers.home;

import com.example.service.FacultiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by supercat on 13.4.17.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }
    @RequestMapping("/startshow")
    public String startshow() {
        return "startshow";
    }
    @RequestMapping("/schedule")
    public String schedule() {return "schedule"; }

    @RequestMapping("/security/startedit")
    public String startedit() {
        return "startedit";
    }
    @RequestMapping("/security/edit")
    public String edit() {
        return "edit";
    }
    @RequestMapping("/security/editday")
    public String editday() {return "editday";}

    @RequestMapping("/security/auditoriums")
    public String auditoriums() {
        return "dynamic";
    }
    @RequestMapping("/security/disciplines")
    public String disciplines() {
        return "dynamic";
    }
    @RequestMapping("/security/pulpits")
    public String pulpits() {
        return "dynamic";
    }
    @RequestMapping("/security/faculties")
    public String faculties() {
        return "dynamic";
    }
    @RequestMapping("/security/teachers")
    public String teachers() {
        return "dynamic";
    }
}