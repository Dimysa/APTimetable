package com.example.repository;

import com.example.models.AcademicPlan;
import com.example.models.Load;
import com.example.models.id.LoadId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by supercat on 7.5.17.
 */
public interface LoadRepository extends JpaRepository<Load, LoadId> {
    List<Load> findByCodeOfSpecialtyAndSemester(String codeOfSpeciality, int semester);
    List<Load> findByIdOfDisciplineAndSemester(int idOfDiscipline, int semester);
    List<Load> findByCodeOfSpecialtyAndSemesterAndShortNameOfLoad(String codeOfSpecialty, int semester, String shortNameOfLoad);
}
