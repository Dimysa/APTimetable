package com.example.repository;

import com.example.models.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by supercat on 28.4.17.
 */
public interface TimetableRepository extends JpaRepository<Timetable, Integer> {

    @Query(value = "SELECT count(*) FROM timetable_insert(?1, ?2, ?3, ?4, ?5, ?6, ?7)", nativeQuery = true)
    void timetableInsert(int calendarId, String numberOfAuditorium, int idOfDiscipline,
                         String typeOfLoad, String codeOfSpecialty, int semester, int idOfTeacher);

}
