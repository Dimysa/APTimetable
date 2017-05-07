package com.example.controllers;

import com.example.models.Time;
import com.example.repository.TimeRepository;
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
public class TimeController {
    @Autowired
    TimeRepository timeRepository;


    @RequestMapping(value = "/Time", method = RequestMethod.GET)
    public ResponseEntity<List<Time>> getTime() {
        return ResponseEntity.ok(timeRepository.findAll());
    }

}
