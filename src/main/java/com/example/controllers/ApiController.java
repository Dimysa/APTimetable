package com.example.controllers;

import com.example.models.*;
import com.example.repository.TimeRepository;
import com.example.repository.TypeOfAuditoriumRepository;
import com.example.repository.ViewTimetableRepository;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by supercat on 9.4.17.
 */
@RestController
public class ApiController {

    @Autowired
    FacultiesService facultiesService;

    @RequestMapping(value = "/EditParams", params = {"faculty", "course", "semester"}, produces = "application/json")
    public String editParams(@RequestParam("faculty") String faculty, @RequestParam("course") int course, @RequestParam("semester") int sem) {
        int semester;
        int idFaculty = (int)facultiesService.findByShortName(faculty).getId();
        if(sem == 2)
            semester = course * 2;
        else
            semester = course * 2 - 1;
        Params result = new Params(idFaculty, semester);
        return result.toString();
    }

}
