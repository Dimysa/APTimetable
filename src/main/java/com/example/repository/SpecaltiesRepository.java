package com.example.repository;

import com.example.models.Specialties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by supercat on 24.4.17.
 */
public interface SpecaltiesRepository extends JpaRepository<Specialties, String> {
    List<Specialties> findByShortNameOfSpecialty(String shortNameOfSpecialty);
    List<Specialties> findByIdOfFaculty(int idOfFaculty);
}
