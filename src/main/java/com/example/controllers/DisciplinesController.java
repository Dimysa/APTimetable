package com.example.controllers;

import com.example.models.AcademicPlan;
import com.example.models.Disciplines;
import com.example.models.Faculties;
import com.example.models.Specialties;
import com.example.service.AcademicPlanService;
import com.example.service.DisciplinesService;
import com.example.service.FacultiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by supercat on 7.5.17.
 */
@RestController
public class DisciplinesController {

    @Autowired
    DisciplinesService disciplinesService;
    @Autowired
    FacultiesService facultiesService;
    @Autowired
    AcademicPlanService academicPlanService;

    @RequestMapping(value = "/Disciplines", params = {"idFaculty", "semester"}, method = RequestMethod.GET)
    public List<Disciplines> getDisciplines(@RequestParam("idFaculty") int idFac, @RequestParam("semester") int sem) {
        List<Disciplines> resultList = new ArrayList<>();
        Faculties faculties = facultiesService.findById(idFac);
        for (Specialties item :
                faculties.getSpecialties()) {
            List<AcademicPlan> list = academicPlanService.findByCodeSpecAndSem(item.getCodeOfSpecialty(), sem);
            for (AcademicPlan ap :
                    list) {
                resultList.add(ap.getDiscipline());
            }
        }
        return resultList;
    }
}
