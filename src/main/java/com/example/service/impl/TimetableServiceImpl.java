package com.example.service.impl;

import com.example.models.Substream;
import com.example.models.Timetable;
import com.example.repository.StreamRepository;
import com.example.repository.TimetableRepository;
import com.example.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Created by supercat on 30.4.17.
 */
@Service
public class TimetableServiceImpl implements TimetableService {
    @Autowired
    TimetableRepository timetableRepository;
    @Autowired
    StreamRepository streamRepository;
    @Override
    public boolean save(Timetable timetable) {
        try {
            if (timetable.getIdOfStream() == null) {
                timetableRepository.save(timetable);
            } else {
                Collection<Substream> stream = streamRepository.findOne(timetable.getIdOfStream()).getSubstreams();
                for (Substream item : stream
                        ) {
                    timetable.setCodeOfSpecialty(item.getCodeOfSpecialty());
                    timetableRepository.save(timetable);
                }
            }
            timetableRepository.flush();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
