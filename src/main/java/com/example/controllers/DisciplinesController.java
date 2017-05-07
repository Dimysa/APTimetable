package com.example.controllers;

import com.example.models.Disciplines;
import com.example.service.DisciplinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by supercat on 7.5.17.
 */
@RestController
public class DisciplinesController {

    @Autowired
    DisciplinesService disciplinesService;

    @RequestMapping(value = "/Disciplines", params = {"idFaculty", "semester"}, method = RequestMethod.GET)
    public List<Disciplines> getDisciplines(@RequestParam("idFaculty") int idFac, @RequestParam("semester") int sem) {
        return disciplinesService.findByIdOfFacAndSem(idFac, sem);
    }
}
