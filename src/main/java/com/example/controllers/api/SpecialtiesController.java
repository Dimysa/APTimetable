package com.example.controllers.api;

import com.example.controllers.crud.CrudController;
import com.example.models.AcademicPlan;
import com.example.models.Specialties;
import com.example.repository.SpecaltiesRepository;
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
@RequestMapping(value = "/security/Specialties")
public class SpecialtiesController extends CrudController<Specialties, String, SpecaltiesRepository> {

    @Autowired
    SpecialtiesService specialtiesService;
    @Autowired
    DisciplinesService disciplinesService;
    @Autowired
    AcademicPlanService academicPlanService;

    @RequestMapping(method = RequestMethod.GET, params = {"idDiscipline", "semester"})
    public List<Specialties> getSpecialties(@RequestParam("idDiscipline") int id, @RequestParam("semester") int sem) {
        List<Specialties> result = new ArrayList<Specialties>();        
        List<AcademicPlan> list =  academicPlanService.findByIdOfDisciplineAndSemester(id, sem);
        for (AcademicPlan item :
                list) {
            result.add(item.getSpecialty());
        }
        return result;
    }
    @RequestMapping(method = RequestMethod.GET, params = {"idFaculty"})
    public List<Specialties> getSpecialties(@RequestParam("idFaculty") int idFaculty){
        return specialtiesService.findByIdOfFaculty(idFaculty);
    }

}
