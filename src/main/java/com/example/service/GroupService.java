package com.example.service;

import com.example.models.Group;

import java.util.List;

/**
 * Created by supercat on 24.4.17.
 */
public interface GroupService {
    List<Group> findByCodeOfSpecialtyAndSemestry(String codeOfSpecialty, int semestry);

}
