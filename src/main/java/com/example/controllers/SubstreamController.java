package com.example.controllers;

import com.example.models.Substream;
import com.example.service.SubstreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by supercat on 7.5.17.
 */
@RestController
public class SubstreamController {

    @Autowired
    SubstreamService substreamService;

    @RequestMapping(value = "/Substream")
    public List<Substream> getSubstream() {
        return substreamService.findAll();
    }

}
