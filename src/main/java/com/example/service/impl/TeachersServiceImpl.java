package com.example.service.impl;

import com.example.models.Teachers;
import com.example.repository.TeachersRepository;
import com.example.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by supercat on 28.4.17.
 */
@Service
public class TeachersServiceImpl implements TeachersService {
    @Autowired
    TeachersRepository teachersRepository;

    @Override
    public List<Teachers> findAll() {
        return teachersRepository.findAll();
    }
}
