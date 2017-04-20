package com.example.controllers;

import com.example.models.*;
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
    @Autowired
    TypeOfLoadService typeOfLoadService;
    @Autowired
    AuditoriumsService auditoriumsService;
    @Autowired
    AcademicPlanService academicPlanService;
    @Autowired
    DisciplinesService disciplinesService;

    @RequestMapping("/")
    public ResponseEntity<String> Get() {
        return ResponseEntity.ok("Test");
    }
    @RequestMapping("/Faculties")
    public List<Faculties> getFaculty() {
        List<Faculties> list = facultiesService.getAllFaculties();
//        list.add(new Faculties(1, "FIT", "Test Name"));
//        list.add(new Faculties(2, "PIM", "Name"));
        return list;
    }
    @RequestMapping("/GetTypeOfLoad")
    public List<TypeOfLoad> getTypeOfLoad() {
        return typeOfLoadService.getAll();
    }
    @RequestMapping(value = "/GetAuditoriums", method = RequestMethod.GET)
    public List<Auditoriums> getAuditoriums(@RequestParam("type") String type) {
        return auditoriumsService.findByType(type);
    }
    @RequestMapping("/GetDisciplines")
    public List<Disciplines> getDisciplines(@RequestParam("idFac") int idFac, @RequestParam("sem") int sem) {
        return disciplinesService.findByIdOfFacAndSem(idFac, sem);
    }
}
