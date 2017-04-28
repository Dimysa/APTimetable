package com.example.service;

import com.example.models.Stream;

import javax.validation.groups.ConvertGroup;
import java.util.List;

/**
 * Created by supercat on 24.4.17.
 */
public interface StreamService {
    List<Stream> findAll();
}
