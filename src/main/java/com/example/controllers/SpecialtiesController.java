package com.example.controllers;

import com.example.models.AcademicPlan;
import com.example.models.Specialties;
import com.example.service.AcademicPlanService;
import com.example.service.DisciplinesService;
import com.example.service.SpecialtiesService;
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
public class SpecialtiesController {

    @Autowired
    SpecialtiesService specialtiesService;
    @Autowired
    DisciplinesService disciplinesService;
    @Autowired
    AcademicPlanService academicPlanService;

    @RequestMapping(value = "/Specialties", method = RequestMethod.GET, params = {"nameDiscipline", "semester"})
    public List<Specialties> getSpecialties(@RequestParam("nameDiscipline") String nameDisc, @RequestParam("semester") int sem) {
        List<Specialties> result = new ArrayList<Specialties>();
        int id = disciplinesService.findByName(nameDisc).getId();
        List<AcademicPlan> list =  academicPlanService.findByIdOfDisciplineAndSemester(id, sem);
        for (AcademicPlan item :
                list) {
            result.add(item.getSpecialty());
        }
        return result;
    }
    @RequestMapping(value = "/Specialties", method = RequestMethod.GET, params = {"idFaculty"})
    public List<Specialties> getSpecialties(@RequestParam("idFaculty") int idFaculty){
        return specialtiesService.findByIdOfFaculty(idFaculty);
    }
    @RequestMapping(value = "/Specialties", method = RequestMethod.GET)
    public List<Specialties> getSpecialties() {
        return specialtiesService.findAll();
    }


}
