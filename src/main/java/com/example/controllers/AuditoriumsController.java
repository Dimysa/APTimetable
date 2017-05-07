package com.example.controllers;

import com.example.models.Auditoriums;
import com.example.service.AuditoriumsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by supercat on 7.5.17.
 */
@RestController
public class AuditoriumsController {

    @Autowired
    AuditoriumsService auditoriumsService;

    @RequestMapping(value = "/Auditoriums", method = RequestMethod.GET)
    public List<Auditoriums> getAuditoriums(@RequestParam("type") String type) {
        return auditoriumsService.findByType(type);
    }
}
