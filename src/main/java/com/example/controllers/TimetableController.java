package com.example.controllers;

import com.example.models.Timetable;
import com.example.models.ViewTimetable;
import com.example.repository.ViewTimetableRepository;
import com.example.service.SpecialtiesService;
import com.example.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by supercat on 7.5.17.
 */
@RestController
public class TimetableController {

    @Autowired
    TimetableService timetableService;
    @Autowired
    ViewTimetableRepository viewTimetableRepository;
    @Autowired
    SpecialtiesService specialtiesService;

    @RequestMapping(value = "/Timetable", method = RequestMethod.POST)
    public ResponseEntity timetable(@RequestBody Timetable timetable) {
        System.out.println("TEST");
        if(timetableService.save(timetable))
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @RequestMapping(value = "/Timetable", method = RequestMethod.GET)
    public ResponseEntity<List<ViewTimetable>> getTimetable() {
        return ResponseEntity.ok(viewTimetableRepository.getView());
    }
    @RequestMapping(value = "/Timetable", method = RequestMethod.GET, params = {"codeSpec", "semester"})
    public ResponseEntity<List<ViewTimetable>>getTimetable(@RequestParam("codeSpec") String codeSpec, @RequestParam("semester") Integer sem) {
        String fullNameSpec = specialtiesService.findOne(codeSpec).getFullNameOfSpecialty();
        return ResponseEntity.ok(viewTimetableRepository.findByFullNameOfSpecialtyAndSemester(fullNameSpec, sem));
    }
    @RequestMapping(value = "/Timetable/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTimetable(@PathVariable int id) {
        timetableService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
