package com.example.service.impl;

import com.example.models.Stream;
import com.example.repository.StreamRepository;
import com.example.service.StreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by supercat on 24.4.17.
 */
@Service
public class StreamServiceImpl implements StreamService {

    @Autowired
    StreamRepository streamRepository;
    @Override
    public List<Stream> findAll() {
        return streamRepository.findAll();
    }
}
