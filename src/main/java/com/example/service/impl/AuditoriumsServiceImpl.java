package com.example.service.impl;

import com.example.repository.AuditoriumsRepository;
import com.example.models.Auditoriums;
import com.example.service.AuditoriumsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by supercat on 18.4.17.
 */
@Service
public class AuditoriumsServiceImpl implements AuditoriumsService {

    @Autowired
    AuditoriumsRepository auditoriumsRepository;
    @Override
    public List<Auditoriums> getAllAuditoriums() {
        return auditoriumsRepository.findAll();
    }

    @Override
    public List<Auditoriums> findByType(String type) {
        return auditoriumsRepository.findByShortNameOfAuditoriumContains(type);
    }
}
