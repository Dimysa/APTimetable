package com.example.service.impl;

import com.example.models.Substream;
import com.example.repository.SubstreamRepository;
import com.example.service.SubstreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by supercat on 24.4.17.
 */
@Service
public class SubstreamServiceImpl implements SubstreamService {

    @Autowired
    SubstreamRepository substreamRepository;

    @Override
    public List<Substream> findBySemAndIdOfDisc(int sem, int id) {
        return substreamRepository.findBySemesterAndIdOfDiscipline(sem, id);
    }

    @Override
    public List<Substream> findAll() {
        return substreamRepository.findAll();
    }
}
