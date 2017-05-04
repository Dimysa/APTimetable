package com.example.repository;

import com.example.models.ViewTimetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.View;
import java.util.List;

/**
 * Created by supercat on 1.5.17.
 */
public interface ViewTimetableRepository extends JpaRepository<ViewTimetable, Integer> {
    @Query(value = "SELECT * FROM view_timetable", nativeQuery = true)
    List<ViewTimetable> getView();

    List<ViewTimetable> findByFullNameOfSpecialtyAndSemester(String fullNameOfSpecialty, Integer semester);
}
