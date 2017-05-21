package com.example.controllers.api;

import com.example.controllers.crud.CrudController;
import com.example.models.Calendar;
import com.example.models.Timetable;
import com.example.repository.CalendarRepository;
import com.example.repository.TimetableRepository;
import com.example.repository.ViewTimetableRepository;
import com.example.service.SpecialtiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by supercat on 7.5.17.
 */
@RestController
@RequestMapping(value = "/security/Timetable")
public class TimetableController extends CrudController<Timetable, Integer, TimetableRepository> {

    @Autowired
    TimetableRepository timetableRepository;
    @Autowired
    CalendarRepository calendarRepository;

    @RequestMapping(method = RequestMethod.PUT, params = {"day", "idClass", "numberOfWeek"})
    public ResponseEntity insertTimetable(@RequestBody Timetable timetable,
                                          @RequestParam("day") int day,
                                          @RequestParam("idClass") int idClass,
                                          @RequestParam("numberOfWeek") int numberOfWeek) {
        List<Calendar> calendarList = calendarRepository.findByIdClass(idClass);
        for (Calendar item : calendarList) {
            if (item.getCalendarDate().getDay() == day && item.getNumberOfWeek() % 2 == numberOfWeek % 2) {
                timetable.setCalendarId(item.getId());
                Timetable saveTable = new Timetable(timetable);
                if (saveTable.getGroup() == null)
                    timetableRepository.timetableInsert(timetable.getCalendarId(), timetable.getNumberOfAuditorium(), timetable.getIdOfDiscipline(), timetable.getTypeOfLoad(), timetable.getCodeOfSpecialty(), timetable.getSemester(), timetable.getIdOfTeacher());
                else
                    timetableRepository.save(saveTable);
            }
        }
        return new ResponseEntity(HttpStatus.OK);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ResponseEntity updateTimetable(@RequestBody Timetable timetable,
                                          @PathVariable int id) {
        Timetable table = timetableRepository.findOne(id);
        table.update(timetable);
        timetableRepository.save(table);
        timetableRepository.flush();
        return new ResponseEntity(HttpStatus.OK);
    }
}
