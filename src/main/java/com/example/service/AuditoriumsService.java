package com.example.service;

import com.example.models.Auditoriums;

import java.util.List;

/**
 * Created by supercat on 18.4.17.
 */
public interface AuditoriumsService {
    List<Auditoriums> getAllAuditoriums();
    List<Auditoriums> findByType(String type);
}
