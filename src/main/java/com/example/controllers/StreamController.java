package com.example.controllers;

import com.example.models.Stream;
import com.example.models.Substream;
import com.example.service.DisciplinesService;
import com.example.service.StreamService;
import com.example.service.SubgroupService;
import com.example.service.SubstreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by supercat on 7.5.17.
 */
@RestController
public class StreamController {

    @Autowired
    StreamService streamService;
    @Autowired
    DisciplinesService disciplinesService;
    @Autowired
    SubstreamService substreamService;

    @RequestMapping(value = "/Stream", params = {"nameDiscipline", "semester"}, method = RequestMethod.GET)
    public List<Stream> getStreamByNameDiscAndSem(@RequestParam("nameDiscipline") String nameDisc, @RequestParam("semester") int sem) {
        List<Stream> list = new ArrayList<Stream>();
        int id = disciplinesService.findByName(nameDisc).getId();
        for (Substream item : substreamService.findBySemAndIdOfDisc(sem, id)
                ) {
            list.add(item.getStream());
        }
        return list.stream().distinct().collect(Collectors.toList());
    }
    @RequestMapping(value = "/Stream", method = RequestMethod.GET)
    public List<Stream> getStream() {
        return streamService.findAll();
    }

}
