package com.example.controllers.api;

import com.example.models.Faculties;
import com.example.models.Group;
import com.example.models.Specialties;
import com.example.repository.FacultiesRepository;
import com.example.repository.SpecaltiesRepository;
import com.example.service.GroupService;
import com.example.service.SpecialtiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dimys on 5/17/2017.
 */
@RestController
public class NonSecurityController {
    @Autowired
    FacultiesRepository facultiesRepository;
    @Autowired
    SpecialtiesService specialtiesService;
    @Autowired
    GroupService groupService;

    @RequestMapping(value = "/Faculties", method = RequestMethod.GET)
    public ResponseEntity<List<Faculties>> getFaculties() {
        return ResponseEntity.ok(facultiesRepository.findAll());
    }

    @RequestMapping(value = "/Specialties", method = RequestMethod.GET, params = {"idFaculty"})
    public ResponseEntity<List<Specialties>> getSpecialties(@RequestParam("idFaculty") int idFac) {
        return ResponseEntity.ok(specialtiesService.findByIdOfFaculty(idFac));
    }

    @RequestMapping(value = "/Group", method = RequestMethod.GET, params = {"codeSpec", "semester"})
    public ResponseEntity<List<Group>> getGroups(@RequestParam("codeSpec") String codeSpec, @RequestParam("semester") int sem) {
        return ResponseEntity.ok(groupService.findByCodeOfSpecialtyAndSemestry(codeSpec, sem));
    }
}
