package com.example.service;

import com.example.models.Specialties;

import java.util.List;

/**
 * Created by supercat on 27.4.17.
 */
public interface SpecialtiesService {
    List<Specialties> findByShortName(String shortName);
    List<Specialties> findByIdOfFaculty(int idOfFaculty);
    List<Specialties> findAll();
    Specialties findOne(String codeSpec);
}