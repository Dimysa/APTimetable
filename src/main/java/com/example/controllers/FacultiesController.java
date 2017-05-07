package com.example.controllers;

import com.example.models.Faculties;
import com.example.service.FacultiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by supercat on 7.5.17.
 */
@RestController
public class FacultiesController {

    @Autowired
    FacultiesService facultiesService;

    @RequestMapping(value = "/Faculties", method = RequestMethod.GET)
    public List<Faculties> getFaculties() {
        List<Faculties> list = facultiesService.findAllFaculties();
        return list;
    }
    @RequestMapping(value = "/Faculties", method = RequestMethod.POST)
    public ResponseEntity<Faculties> saveFaculties(@RequestBody Faculties faculties) {
        Faculties fac = facultiesService.saveOrUpdate(faculties);
        if(fac == null)
            return new ResponseEntity<Faculties>(HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<Faculties>(fac, HttpStatus.OK);
    }
    @RequestMapping(value = "/Faculties/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteFaulty(@PathVariable Integer id) {
        facultiesService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
