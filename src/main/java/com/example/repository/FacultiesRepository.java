package com.example.repository;

import com.example.models.*;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by supercat on 13.4.17.
 */
public interface FacultiesRepository extends CrudRepository<Faculties, Long> {
    Faculties findByShortNameOfFaculty(String shortNameOfFaculty);
}
