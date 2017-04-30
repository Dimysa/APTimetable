package com.example.service.impl;

import com.example.models.Timetable;
import com.example.repository.TimetableRepository;
import com.example.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by supercat on 30.4.17.
 */
@Service
public class TimetableServiceImpl implements TimetableService {
    @Autowired
    TimetableRepository timetableRepository;
    @Override
    public void save(Timetable timetable) {

    }
}
