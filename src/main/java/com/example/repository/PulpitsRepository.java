package com.example.repository;

import com.example.models.Pulpits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by supercat on 24.5.17.
 */
public interface PulpitsRepository extends JpaRepository<Pulpits, Integer> {
}
