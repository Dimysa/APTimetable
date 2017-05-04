package com.example.service.impl;

import com.example.models.Specialties;
import com.example.repository.SpecaltiesRepository;
import com.example.service.SpecialtiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by supercat on 27.4.17.
 */
@Service
public class SpecialtiesServiceImpl implements SpecialtiesService {
    @Autowired
    SpecaltiesRepository specaltiesRepository;

    @Override
    public List<Specialties> findByShortName(String shortName) {
        return specaltiesRepository.findByShortNameOfSpecialty(shortName);
    }

    @Override
    public List<Specialties> findByIdOfFaculty(int idOfFaculty) {
        return specaltiesRepository.findByIdOfFaculty(idOfFaculty);
    }

    @Override
    public List<Specialties> findAll() {
        return specaltiesRepository.findAll();
    }

    @Override
    public Specialties findOne(String codeSpec) {
        return specaltiesRepository.findOne(codeSpec);
    }
}
