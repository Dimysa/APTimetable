package com.example.service;

import com.example.models.Timetable;

/**
 * Created by supercat on 30.4.17.
 */
public interface TimetableService {
    boolean save(Timetable timetable);
    void delete(int id);
}
