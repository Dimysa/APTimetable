package com.example.service.impl;

import com.example.models.Timetable;
import com.example.repository.TimetableRepository;
import com.example.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Created by supercat on 30.4.17.
 */
@Service
public class TimetableServiceImpl implements TimetableService {

    @Override
    public boolean save(Timetable timetable) {
        return false;
    }

    @Override
    public void delete(int id) {

    }
}
