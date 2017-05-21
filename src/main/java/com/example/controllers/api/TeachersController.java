package com.example.controllers.api;

import com.example.controllers.crud.CrudController;
import com.example.models.Teachers;
import com.example.repository.TeachersRepository;
import com.example.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by supercat on 7.5.17.
 */
@RestController
@RequestMapping(value = "/security/Teachers")
public class TeachersController extends CrudController<Teachers, Integer, TeachersRepository> {

}
