package com.example.controllers.api;

import com.example.controllers.crud.CrudController;
import com.example.models.Group;
import com.example.models.Specialties;
import com.example.models.id.GroupId;
import com.example.repository.GroupRepository;
import com.example.service.FacultiesService;
import com.example.service.GroupService;
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
@RequestMapping(value = "/security/Group")
public class GroupController extends CrudController<Group, GroupId, GroupRepository> {

    @Autowired
    GroupRepository groupRepository;
    @Autowired
    SpecialtiesService specialtiesService;
    @Autowired
    FacultiesService facultiesService;

    @RequestMapping(method = RequestMethod.GET, params = {"codeOfSpecialty", "semester"})
    public List<Group> getGroup(@RequestParam("codeOfSpecialty") String codeSpec, @RequestParam("semester") int sem) {
        Specialties spec = specialtiesService.findOne(codeSpec);
        return new ArrayList<>(spec.getGroups());
    }
    @RequestMapping(method=RequestMethod.GET, params = {"idFaculty", "semester"})
    public List<Group> getGroup(@RequestParam("idFaculty") int idFaculty, @RequestParam("semester") int sem) {
    	List<Group> resList = new ArrayList<>();
        List<Specialties> list = new ArrayList<>(facultiesService.findById(idFaculty).getSpecialties());
        for (Specialties item :
                list) {
            resList.addAll(item.getGroups());
        }
        return resList;
    }
}
