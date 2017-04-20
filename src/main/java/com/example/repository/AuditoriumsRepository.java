package com.example.repository;
import com.example.models.Auditoriums;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by supercat on 18.4.17.
 */
public interface AuditoriumsRepository extends JpaRepository<Auditoriums, String> {

    //@Query("select u from auditorium u where u.short_name_of_auditorium like ?1")
    List<Auditoriums> findByShortNameOfAuditoriumContains (String shortNameOfAuditorium);
}
