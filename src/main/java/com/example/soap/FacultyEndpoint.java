package com.example.soap;

import com.example.models.Faculties;
import com.example.service.FacultiesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class FacultyEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/soap";
    @Autowired
    private FacultiesService facultiesService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getFacultyRequest")
    @ResponsePayload
    public GetFacultyResponse getFaculty(@RequestPayload GetFacultyRequest request) {
        GetFacultyResponse response = new GetFacultyResponse();
        SoapFaculty sf = new SoapFaculty();
        Faculties faculties = facultiesService.findById(request.getId());
        sf.setId(faculties.getId());
        sf.setShortNameOfFaculty(faculties.getShortNameOfFaculty());
        sf.setFullNameOfFaculty(faculties.getFullNameOfFaculty());

        response.setFaculty(sf);
        return response;
    }
}