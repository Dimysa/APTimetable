package com.example.repository;

import com.example.models.ViewTimetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import javax.swing.text.View;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 * Created by supercat on 1.5.17.
 */
public interface ViewTimetableRepository extends JpaRepository<ViewTimetable, Integer> {
    List<ViewTimetable> findByFullNameOfSpecialtyAndSemester(String fullNameOfSpecialty, Integer semester);
    List<ViewTimetable> findByDateBetweenAndAndFullNameOfSpecialtyAndSemester(Date startDate, Date endDate, String fullNameOfSpecialty, int semester);
    List<ViewTimetable> findByDateBetweenAndAndFullNameOfSpecialtyAndSemesterAndGroupNumAndSubgroup(Date startDate, Date endDate, String fullNameOfSpecialty, int semester, int groupNum, int subgroup);

    @Query(value = "SELECT * FROM timetable_select(?1, ?2, ?3)", nativeQuery = true)
    List<Object> callTimetableSelect(String codeOfSpecialty, int semester, int dayOfWeek);
}
