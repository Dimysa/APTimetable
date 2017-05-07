package com.example.repository;

import com.example.models.Time;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by supercat on 7.5.17.
 */
public interface TimeRepository extends JpaRepository<Time, Integer> {

}
