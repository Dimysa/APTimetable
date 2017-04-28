package com.example.service;

import com.example.models.Disciplines;
import com.example.repository.DisciplinesRepository;

import java.util.List;

/**
 * Created by supercat on 19.4.17.
 */
public interface DisciplinesService {
    Disciplines findByName(String name);
    Disciplines findById(int id);
    List<Disciplines> findByIdOfFacAndSem(int idOfFac, int sem);
}
