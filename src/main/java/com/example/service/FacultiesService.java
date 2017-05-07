package com.example.service;

import com.example.models.Faculties;

import java.util.List;

/**
 * Created by supercat on 13.4.17.
 */
public interface FacultiesService {
    List<Faculties> findAllFaculties();
    Faculties findByShortName(String shortName);
    Faculties saveOrUpdate(Faculties faculties);
    void delete(Integer id);
    Faculties findById(int id);
}
