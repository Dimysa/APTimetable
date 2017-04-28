package com.example.service;

import com.example.models.Subgroup;

import java.util.List;

/**
 * Created by supercat on 26.4.17.
 */
public interface SubgroupService {
    List<Subgroup> findByCodeSpecAndSem(String codeSpec, int sem);
    List<Subgroup> findByCodeSpecAndSemAndGroup(String codeSpec, int sem, int gr);
}
