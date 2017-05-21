package com.example.controllers.api;

import com.example.controllers.crud.CrudController;
import com.example.models.Specialties;
import com.example.models.Subgroup;
import com.example.models.id.SubgroupId;
import com.example.repository.SubgroupRepository;
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
@RequestMapping(value = "/security/Subgroup")
public class SubgroupController extends CrudController<Subgroup, SubgroupId, SubgroupRepository>{

    @Autowired
    SubgroupService subgroupService;

    @RequestMapping(method = RequestMethod.GET, params = {"codeOfSpecialty", "semester", "group"})
    public List<Subgroup> getSubgroup(@RequestParam("codeOfSpecialty") String codeSpec, @RequestParam("semester") int sem, @RequestParam("group") int group) {
        return subgroupService.findByCodeSpecAndSemAndGroup(codeSpec, sem, group);
    }
    @RequestMapping(method = RequestMethod.GET, params = {"codeOfSpecialty", "semester"})
    public List<Subgroup> getSubgroup(@RequestParam("codeOfSpecialty") String codeSpec, @RequestParam("semester") int sem) {
    	return subgroupService.findByCodeSpecAndSem(codeSpec, sem);
    }

}
