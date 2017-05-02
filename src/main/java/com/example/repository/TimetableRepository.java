package com.example.repository;

import com.example.models.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by supercat on 28.4.17.
 */
public interface TimetableRepository extends JpaRepository<Timetable, Integer> {

}
