package com.example.controllers.api;

import com.example.controllers.crud.CrudController;
import com.example.models.Calendar;
import com.example.models.ViewTimetable;
import com.example.repository.CalendarRepository;
import com.example.repository.ViewTimetableRepository;
import com.example.service.SpecialtiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by supercat on 11.5.17.
 */
@RestController
@RequestMapping(value = "/ViewTimetable")
public class ViewTimetableController extends CrudController<ViewTimetable, Integer, com.example.repository.ViewTimetableRepository> {
    @Autowired
    SpecialtiesService specialtiesService;
    @Autowired
    ViewTimetableRepository viewTimetableRepository;

    @RequestMapping(method = RequestMethod.GET, params = {"codeSpec", "semester", "group", "subgroup", "startDate", "endDate"})
    public ResponseEntity<List<ViewTimetable>> getTimetable(@RequestParam("codeSpec") String codeSpec,
                                                            @RequestParam("semester") int sem,
                                                            @RequestParam("group") int group,
                                                            @RequestParam("subgroup") int subgroup,
                                                            @RequestParam("startDate") String startDate,
                                                            @RequestParam("endDate") String endDate) {
        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date sDate = format.parse(startDate);
            Date eDate = format.parse(endDate);
            String fullNameSpec = specialtiesService.findOne(codeSpec).getFullNameOfSpecialty();
            List<ViewTimetable> timetables = viewTimetableRepository.findByDateBetweenAndAndFullNameOfSpecialtyAndSemesterAndGroupNumAndSubgroup(sDate, eDate, fullNameSpec, sem, group, subgroup);
            return ResponseEntity.ok(timetables);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<ViewTimetable>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, params = {"codeSpec", "semester", "group", "subgroup"})
    public ResponseEntity<List<ViewTimetable>> getTimetable(@RequestParam("codeSpec") String codeSpec,
                                                            @RequestParam("semester") int sem,
                                                            @RequestParam("group") int group,
                                                            @RequestParam("subgroup") int subgroup) {
        String fullNameSpec = specialtiesService.findOne(codeSpec).getFullNameOfSpecialty();
        return ResponseEntity.ok(viewTimetableRepository.findByFullNameOfSpecialtyAndSemester(fullNameSpec, sem));
    }
    @RequestMapping(method = RequestMethod.GET, params = {"codeSpec", "semester", "startDate", "endDate"})
    public ResponseEntity<List<ViewTimetable>> getViewTimetable(@RequestParam("codeSpec") String codeSpec,
                                                                @RequestParam("semester") int sem,
                                                                @RequestParam("startDate") String startDate,
                                                                @RequestParam("endDate") String endDate) {
        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date sDate = format.parse(startDate);
            Date eDate = format.parse(endDate);
            String fullNameSpec = specialtiesService.findOne(codeSpec).getFullNameOfSpecialty();
            List<ViewTimetable> timetables = viewTimetableRepository.findByDateBetweenAndAndFullNameOfSpecialtyAndSemester(sDate, eDate, fullNameSpec, sem);
            return ResponseEntity.ok(timetables);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<ViewTimetable>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(method = RequestMethod.GET, params = {"codeSpec", "semester", "day"})
    public ResponseEntity<List<Object>> getViewTimetable(@RequestParam("codeSpec") String codeSpec,
                                                                @RequestParam("semester") int sem,
                                                                @RequestParam("day")int day) {
        return ResponseEntity.ok(viewTimetableRepository.callTimetableSelect(codeSpec, sem, day));
    }
}
