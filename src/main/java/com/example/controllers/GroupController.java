package com.example.controllers;

import com.example.models.Group;
import com.example.models.Specialties;
import com.example.service.GroupService;
import com.example.service.SpecialtiesService;
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
public class GroupController {

    @Autowired
    GroupService groupService;
    @Autowired
    SpecialtiesService specialtiesService;

    @RequestMapping(value = "/Group", method = RequestMethod.GET, params = {"nameSpec", "semester"})
    public List<Group> getGroup(@RequestParam("nameSpec") String nameSpec, @RequestParam("semester") int sem) {
        Specialties spec = specialtiesService.findByShortName(nameSpec).get(0);
        return groupService.findByCodeOfSpecialtyAndSemestry(spec.getCodeOfSpecialty(), sem);
    }
}
