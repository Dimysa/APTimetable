package com.example.models;

import java.io.Serializable;

/**
 * Created by supercat on 7.5.17.
 */
public class Params implements Serializable {
    int idFaculty;
    int semester;

    public Params(int idFaculty, int semester) {
        this.idFaculty = idFaculty;
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "{" +
                "\"idFaculty\":" + idFaculty +
                ", \"semester\":" + semester +
                '}';
    }
}
