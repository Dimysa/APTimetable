package com.example.repository;

import com.example.models.Substream;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by supercat on 24.4.17.
 */
public interface SubstreamRepository extends JpaRepository<Substream, Long> {
    List<Substream> findBySemesterAndIdOfDiscipline(int semestry, int idOfDiscipline);
}
