package com.example.repository;

import com.example.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by supercat on 13.4.17.
 */
public interface FacultiesRepository extends JpaRepository<Faculties, Integer> {
    Faculties findByShortNameOfFaculty(String shortNameOfFaculty);
}