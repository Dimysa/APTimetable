package com.example.models;


import com.example.models.id.AcademicPlanId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "academic_plan")
@IdClass(AcademicPlanId.class)
public class AcademicPlan {

  @Id
  @Column(name = "code_of_specialty", nullable = false)
  private String codeOfSpecialty;
  @Id
  @Column(name = "id_of_discipline", nullable = false)
  private long idOfDiscipline;
  @Id @NotNull
  private long semester;


  public String getCodeOfSpecialty() {
    return codeOfSpecialty;
  }

  public void setCodeOfSpecialty(String codeOfSpecialty) {
    this.codeOfSpecialty = codeOfSpecialty;
  }


  public long getIdOfDiscipline() {
    return idOfDiscipline;
  }

  public void setIdOfDiscipline(long idOfDiscipline) {
    this.idOfDiscipline = idOfDiscipline;
  }


  public long getSemester() {
    return semester;
  }

  public void setSemester(long semester) {
    this.semester = semester;
  }

  public AcademicPlan() {
  }

  @Override
  public String toString() {
    return "AcademicPlan{" +
            "codeOfSpecialty='" + codeOfSpecialty + '\'' +
            ", idOfDiscipline=" + idOfDiscipline +
            ", semester=" + semester +
            '}';
  }
}
