package com.example.controllers;

import com.example.models.*;
import com.example.repository.TimetableRepository;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by supercat on 9.4.17.
 */
class Params implements Serializable {
    int idFaculty;
    int semester;

    public Params(int idFaculty, int semester) {
        this.idFaculty = idFaculty;
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "{" +
                "\"idFaculty\":" + idFaculty +
                ", \"semester\":" + semester +
                '}';
    }
}
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
    @Autowired
    SubstreamService substreamService;
    @Autowired
    StreamService streamService;
    @Autowired
    SubgroupService subgroupService;
    @Autowired
    GroupService groupService;
    @Autowired
    SpecialtiesService specialtiesService;
    @Autowired
    TeachersService teachersService;
    @Autowired
    TimetableRepository timetableRepository;

    @RequestMapping("/ApiInfo")
    public ResponseEntity<String> Get() {
        String result = "/EditParams (params=faculty, course, semester)\n" + "/Faculties\n" + "/TypeOfLoad\n"
                + "/Auditoriums (params = type)\n" + "/Disciplines (params=idFaculty, semester)\n"
                + "/Stream (params=nameDiscipline, semester / null)\n" +
                "/Specialties (params=nameDiscipline, semester / idFaculty)\n";
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/EditParams", params = {"faculty", "course", "semester"}, produces = "application/json")
    public String editParams(@RequestParam("faculty") String faculty, @RequestParam("course") int course, @RequestParam("semester") int sem) {
        int semester;
        int idFaculty = (int)facultiesService.findByShortName(faculty).getId();
        if(sem == 2)
            semester = course * 2;
        else
            semester = course * 2 - 1;
        Params result = new Params(idFaculty, semester);
        return result.toString();
    }

    @RequestMapping("/Faculties")
    public List<Faculties> getFaculties() {
        List<Faculties> list = facultiesService.findAllFaculties();
//        list.add(new Faculties(1, "FIT", "Test Name"));
//        list.add(new Faculties(2, "PIM", "Name"));
        return list;
    }

    @RequestMapping("/TypeOfLoad")
    public List<TypeOfLoad> getTypeOfLoad() {
        return typeOfLoadService.getAll();
    }

    @RequestMapping(value = "/Auditoriums", method = RequestMethod.GET)
    public List<Auditoriums> getAuditoriums(@RequestParam("type") String type) {
        return auditoriumsService.findByType(type);
    }

    @RequestMapping(value = "/Disciplines", params = {"idFaculty", "semester"}, method = RequestMethod.GET)
    public List<Disciplines> getDisciplines(@RequestParam("idFaculty") int idFac, @RequestParam("semester") int sem) {
        return disciplinesService.findByIdOfFacAndSem(idFac, sem);
    }

    @RequestMapping(value = "/Stream", params = {"nameDiscipline", "semester"}, method = RequestMethod.GET)
    public List<Stream> getStreamByNameDiscAndSem(@RequestParam("nameDiscipline") String nameDisc, @RequestParam("semester") int sem) {
        List<Stream> list = new ArrayList<Stream>();
        int id = disciplinesService.findByName(nameDisc).getId();
        for (Substream item : substreamService.findBySemAndIdOfDisc(sem, id)
             ) {
            list.add(item.getStream());
        }
        return list.stream().distinct().collect(Collectors.toList());
    }

    @RequestMapping(value = "/Substream")
    public List<Substream> getSubstream() {
        return substreamService.findAll();
    }

    @RequestMapping(value = "/Stream", method = RequestMethod.GET)
    public List<Stream> getStream() {
        return streamService.findAll();
    }

    @RequestMapping(value = "/Specialties", method = RequestMethod.GET, params = {"nameDiscipline", "semester"})
    public List<Specialties> getSpecialties(@RequestParam("nameDiscipline") String nameDisc, @RequestParam("semester") int sem) {
        List<Specialties> result = new ArrayList<Specialties>();
        int id = disciplinesService.findByName(nameDisc).getId();
        List<AcademicPlan> list =  academicPlanService.findByIdOfDisciplineAndSemester(id, sem);
        for (AcademicPlan item :
                list) {
            result.add(item.getSpecialties());
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

    @RequestMapping(value = "/Group", method = RequestMethod.GET, params = {"nameSpec", "semester"})
    public List<Group> getGroup(@RequestParam("nameSpec") String nameSpec, @RequestParam("semester") int sem) {
        Specialties spec = specialtiesService.findByShortName(nameSpec).get(0);
        return groupService.findByCodeOfSpecialtyAndSemestry(spec.getCodeOfSpecialty(), sem);
    }

    @RequestMapping(value = "/Subgroup", method = RequestMethod.GET, params = {"nameSpec", "semester", "group"})
    public List<Subgroup> getSubgroup(@RequestParam("nameSpec") String nameSpec, @RequestParam("semester") int sem, @RequestParam("group") int group) {
        Specialties spec = specialtiesService.findByShortName(nameSpec).get(0);
        return subgroupService.findByCodeSpecAndSemAndGroup(spec.getCodeOfSpecialty(), sem, group);
    }

    @RequestMapping(value = "/Teachers", method = RequestMethod.GET)
    public List<Teachers> getTeachers() {
        return teachersService.findAll();
    }

    @RequestMapping(value = "/Timetable", method = RequestMethod.POST)
    public void timetable(@RequestBody Timetable timetable) {
        System.out.println("TEST");
        timetableRepository.save(timetable);
    }
}
