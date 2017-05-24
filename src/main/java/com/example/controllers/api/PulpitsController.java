package com.example.controllers.api;

import com.example.controllers.crud.CrudController;
import com.example.models.Pulpits;
import com.example.repository.PulpitsRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by supercat on 24.5.17.
 */
@RestController
@RequestMapping(value = "/security/Pulpits")
public class PulpitsController extends CrudController<Pulpits, Integer, PulpitsRepository> {
}
