package com.example.service.impl;

import com.example.models.Disciplines;
import com.example.repository.DisciplinesRepository;
import com.example.service.DisciplinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by supercat on 19.4.17.
 */
@Service
public class DisciplinesServiceImpl implements DisciplinesService {

    @Autowired
    DisciplinesRepository disciplinesRepository;


    @Override
    public Disciplines findByName(String name) {
        return disciplinesRepository.findByNameOfDiscipline(name);
    }

    @Override
    public Disciplines findById(int id) {
        return disciplinesRepository.findById(id);
    }

    @Override
    public List<Disciplines> findByIdOfFacAndSem(int idOfFac, int sem) {
        return disciplinesRepository.callFindByIdOfFacAndSem(idOfFac, sem);
    }
}
