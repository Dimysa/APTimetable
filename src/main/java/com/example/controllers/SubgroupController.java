package com.example.controllers;

import com.example.models.Specialties;
import com.example.models.Subgroup;
import com.example.service.SpecialtiesService;
import com.example.service.SubgroupService;
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
public class SubgroupController {

    @Autowired
    SubgroupService subgroupService;
    @Autowired
    SpecialtiesService specialtiesService;

    @RequestMapping(value = "/Subgroup", method = RequestMethod.GET, params = {"nameSpec", "semester", "group"})
    public List<Subgroup> getSubgroup(@RequestParam("nameSpec") String nameSpec, @RequestParam("semester") int sem, @RequestParam("group") int group) {
        Specialties spec = specialtiesService.findByShortName(nameSpec).get(0);
        return subgroupService.findByCodeSpecAndSemAndGroup(spec.getCodeOfSpecialty(), sem, group);
    }

}
