package com.example.service.impl;

import com.example.models.Subgroup;
import com.example.repository.SubgroupRepository;
import com.example.service.SubgroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by supercat on 26.4.17.
 */
@Service
public class SubgroupServiceImpl implements SubgroupService {

    @Autowired
    SubgroupRepository subgroupRepository;

    @Override
    public List<Subgroup> findByCodeSpecAndSem(String codeSpec, int sem) {
        return subgroupRepository.findByCodeOfSpecialtyAndSemester(codeSpec, sem);
    }

    @Override
    public List<Subgroup> findByCodeSpecAndSemAndGroup(String codeSpec, int sem, int gr) {
        return subgroupRepository.findByCodeOfSpecialtyAndSemesterAndGroup(codeSpec, sem, gr);
    }
}
