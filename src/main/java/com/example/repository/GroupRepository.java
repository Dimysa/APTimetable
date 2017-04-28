package com.example.repository;

import com.example.models.Group;
import com.example.models.id.GroupId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by supercat on 24.4.17.
 */
public interface GroupRepository extends JpaRepository<Group, GroupId> {
    List<Group> findByCodeOfSpecialtyAndSemester(String codeOfSpecialty, int semester);

}
