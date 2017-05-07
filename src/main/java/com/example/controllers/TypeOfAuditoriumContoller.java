package com.example.controllers;

import com.example.models.TypeOfAuditorium;
import com.example.repository.TypeOfAuditoriumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by supercat on 7.5.17.
 */
@RestController
public class TypeOfAuditoriumContoller {

    @Autowired
    TypeOfAuditoriumRepository typeOfAuditoriumRepository;

    @RequestMapping(value = "TypeOfAuditorium", method = RequestMethod.GET)
    public ResponseEntity<List<TypeOfAuditorium>> getTypeOfAuditorium() {
        return ResponseEntity.ok(typeOfAuditoriumRepository.findAll());
    }
}
