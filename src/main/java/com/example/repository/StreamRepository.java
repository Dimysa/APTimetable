package com.example.repository;

import com.example.models.Stream;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by supercat on 24.4.17.
 */
public interface StreamRepository extends JpaRepository<Stream, Long> {
    
}
