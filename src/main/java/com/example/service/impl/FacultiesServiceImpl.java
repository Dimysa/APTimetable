package com.example.service.impl;

import com.example.repository.FacultiesRepository;
import com.example.models.Faculties;
import com.example.service.FacultiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by supercat on 13.4.17.
 */
@Service
public class FacultiesServiceImpl implements FacultiesService {

    @Autowired
    FacultiesRepository facultiesRepository;

    @Override
    public List<Faculties> findAllFaculties() {
        Iterable<Faculties> temp = facultiesRepository.findAll();
        ArrayList<Faculties> list = new ArrayList<Faculties>();
        if(temp != null) {
            for(Faculties e: temp) {
                list.add(e);
            }
        }
        return list;
    }

    @Override
    public Faculties findByShortName(String shortName) {
        return facultiesRepository.findByShortNameOfFaculty(shortName);
    }

    @Override
    public Faculties saveOrUpdate(Faculties changeFaculty) {
        Faculties faculties = facultiesRepository.findOne(changeFaculty.getId());
        if (faculties == null) {
            try {
                return facultiesRepository.saveAndFlush(changeFaculty);
            }
            catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        else {
            faculties.update(changeFaculty);
            faculties = facultiesRepository.save(faculties);
            facultiesRepository.flush();
            return faculties;
        }
    }

    @Override
    public void delete(Integer id) {
        facultiesRepository.delete(id);
    }

    @Override
    public Faculties findById(int id) {
        return facultiesRepository.findOne(id);
    }
}
