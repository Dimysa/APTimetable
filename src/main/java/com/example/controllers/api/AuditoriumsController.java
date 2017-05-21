package com.example.controllers.api;

import com.example.controllers.crud.CrudController;
import com.example.models.Auditoriums;
import com.example.repository.AuditoriumsRepository;
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
@RequestMapping(value = "/security/Auditoriums")
public class AuditoriumsController extends CrudController<Auditoriums, String, AuditoriumsRepository> {

    @Autowired
    AuditoriumsService auditoriumsService;

    @RequestMapping(params = {"type"}, method = RequestMethod.GET)
    public List<Auditoriums> getAuditoriums(@RequestParam("type") String type) {
        return auditoriumsService.findByType(type);
    }
}
