package com.example.service.impl;

import com.example.repository.TypeOfLoadRepository;
import com.example.models.TypeOfLoad;
import com.example.service.TypeOfLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by supercat on 18.4.17.
 */
@Service
public class TypeOfLoadServiceImpl implements TypeOfLoadService {

    @Autowired
    TypeOfLoadRepository typeOfLoadRepository;
    @Override
    public List<TypeOfLoad> getAll() {
        return typeOfLoadRepository.findAll();
    }
}
