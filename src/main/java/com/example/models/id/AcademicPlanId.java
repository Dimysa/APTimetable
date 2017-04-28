package com.example.models.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by supercat on 19.4.17.
 */
public class AcademicPlanId implements Serializable {
    private String codeOfSpecialty;
    private int idOfDiscipline;
    private int semester;

}
