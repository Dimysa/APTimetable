package com.example.repository;

import com.example.models.AcademicPlan;
import com.example.models.id.AcademicPlanId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by supercat on 19.4.17.
 */
public interface AcademicPlanRepository extends JpaRepository<AcademicPlan, AcademicPlanId> {
    List<AcademicPlan> findByCodeOfSpecialtyAndSemester(String codeOfSpeciality, int semester);
    List<AcademicPlan> findByIdOfDisciplineAndSemester(int idOfDiscipline, int semestry);
}
