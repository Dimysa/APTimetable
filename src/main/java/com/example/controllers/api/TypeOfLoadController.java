package com.example.controllers.api;

import com.example.controllers.crud.CrudController;
import com.example.models.TypeOfLoad;
import com.example.repository.TypeOfLoadRepository;
import com.example.service.TypeOfLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by supercat on 7.5.17.
 */
@RestController
@RequestMapping(value = "/security/TypeOfLoad")
public class TypeOfLoadController extends CrudController<TypeOfLoad, String, TypeOfLoadRepository> {

}
