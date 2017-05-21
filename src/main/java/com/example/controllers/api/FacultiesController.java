package com.example.controllers.api;

import com.example.controllers.crud.CrudController;
import com.example.models.Faculties;
import com.example.repository.FacultiesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by supercat on 7.5.17.
 */
@RestController
@RequestMapping(value = "/security/Faculties")
public class FacultiesController extends CrudController<Faculties, Integer, FacultiesRepository> {

}
