package com.example.controllers.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * Created by supercat on 11.5.17.
 */
@RestController
public abstract class CrudController<ObjectType, IdType extends Serializable, Repository extends JpaRepository<ObjectType, IdType>> {

    @Autowired
    protected Repository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<ObjectType> findAll() {
        return repository.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<String> create(@RequestBody ObjectType object){
        repository.save(object);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> update(@RequestBody ObjectType object){
        repository.save(object);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable IdType id) {
        ObjectType object = repository.findOne(id);
        if (object != null) {
            repository.delete(object);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}")
    public ObjectType findUser(@PathVariable IdType id ) {
        //if (ObjectValidator.validateId(id)) {
        return repository.findOne(id);
        //}
    }
}
