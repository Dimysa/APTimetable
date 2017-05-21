package com.example.repository;

import com.example.models.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by supercat on 8.5.17.
 */
public interface CalendarRepository extends JpaRepository<Calendar, Integer> {
    List<Calendar> findByIdClass(int idClass);
    List<Calendar> findByCalendarDateBetween(Date startDate, Date endDate);
}
