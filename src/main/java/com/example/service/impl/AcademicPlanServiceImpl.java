package com.example.service.impl;

import com.example.models.AcademicPlan;
import com.example.repository.AcademicPlanRepository;
import com.example.service.AcademicPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by supercat on 19.4.17.
 */
@Service
public class AcademicPlanServiceImpl implements AcademicPlanService {

    @Autowired
    AcademicPlanRepository academicPlanRepository;

    @Override
    public List<AcademicPlan> findByCodeSpecAndSem(String code, int sem) {
        return academicPlanRepository.findByCodeOfSpecialtyAndSemester(code, sem);
    }

    @Override
    public List<AcademicPlan> findByIdOfDisciplineAndSemester(int idOfDiscipline, int semestry) {
        return academicPlanRepository.findByIdOfDisciplineAndSemester(idOfDiscipline, semestry);
    }
}
