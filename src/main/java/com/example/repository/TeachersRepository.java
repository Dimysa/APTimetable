package com.example.repository;

import com.example.models.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by supercat on 28.4.17.
 */
public interface TeachersRepository extends JpaRepository<Teachers, Integer> {
}
