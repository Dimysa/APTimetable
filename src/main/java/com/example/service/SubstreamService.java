package com.example.service;

import com.example.models.Substream;

import java.util.List;

/**
 * Created by supercat on 24.4.17.
 */
public interface SubstreamService {
    List<Substream> findBySemAndIdOfDisc(int sem, int id);
    List<Substream> findAll();
}
