package com.example.controllers.api;

import com.example.controllers.crud.CrudController;
import com.example.models.*;
import com.example.models.id.LoadId;
import com.example.repository.LoadRepository;
import com.example.service.FacultiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by supercat on 7.5.17.
 */
@RestController
@RequestMapping(value = "/security/Load")
public class LoadController extends CrudController<Load, LoadId, LoadRepository> {

    @Autowired
    FacultiesService facultiesService;
    @Autowired
    LoadRepository loadRepository;

    @RequestMapping(params = {"idFaculty", "semester", "load"}, method = RequestMethod.GET)
    public List<Disciplines> getDisciplines(@RequestParam("idFaculty") int idFac, @RequestParam("semester") int sem, @RequestParam("load") String load) {
        List<Disciplines> resultList = new ArrayList<>();
        Faculties faculties = facultiesService.findById(idFac);
        for (Specialties item :
                faculties.getSpecialties()) {
            List<Load> list = loadRepository.findByCodeOfSpecialtyAndSemesterAndShortNameOfLoad(item.getCodeOfSpecialty(), sem, load);
            for (Load l :
                    list) {
                resultList.add(l.getAcademicPlan().getDiscipline());
            }
        }
        return resultList.stream().distinct().collect(Collectors.toList());
    }
}
