package com.example.repository;

import com.example.models.Subgroup;
import com.example.models.id.SubgroupId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by supercat on 24.4.17.
 */
public interface SubgroupRepository extends JpaRepository<Subgroup, SubgroupId> {
    List<Subgroup> findByCodeOfSpecialtyAndSemester(String codeOfSpecialty, int semester);
    List<Subgroup> findByCodeOfSpecialtyAndSemesterAndGroup(String codeOfSpecialty, int semester, int group);
}
