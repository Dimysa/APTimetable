package com.example.service.impl;

import com.example.models.Group;
import com.example.repository.GroupRepository;
import com.example.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by supercat on 24.4.17.
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepository groupRepository;
    @Override
    public List<Group> findByCodeOfSpecialtyAndSemestry(String codeOfSpecialty, int semestry) {
        return groupRepository.findByCodeOfSpecialtyAndSemester(codeOfSpecialty, semestry);
    }
}
