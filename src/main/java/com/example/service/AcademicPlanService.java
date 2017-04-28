package com.example.service;

import com.example.models.AcademicPlan;

import java.util.List;

/**
 * Created by supercat on 19.4.17.
 */
public interface AcademicPlanService {
    List<AcademicPlan> findByCodeSpecAndSem(String code, int sem);
    List<AcademicPlan> findByIdOfDisciplineAndSemester(int idOfDiscipline, int semestry);
}
