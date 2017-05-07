package com.example.controllers;

import com.example.models.Teachers;
import com.example.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by supercat on 7.5.17.
 */
@RestController
public class TeachersController {

    @Autowired
    TeachersService teachersService;

    @RequestMapping(value = "/Teachers", method = RequestMethod.GET)
    public List<Teachers> getTeachers() {
        return teachersService.findAll();
    }


}
