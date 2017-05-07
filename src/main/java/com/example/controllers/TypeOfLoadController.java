package com.example.controllers;

import com.example.models.TypeOfLoad;
import com.example.service.TypeOfLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by supercat on 7.5.17.
 */
@RestController
public class TypeOfLoadController {

    @Autowired
    TypeOfLoadService typeOfLoadService;

    @RequestMapping("/TypeOfLoad")
    public List<TypeOfLoad> getTypeOfLoad() {
        return typeOfLoadService.getAll();
    }

}
