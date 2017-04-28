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
  private int idOfDiscipline;
  @Id @NotNull
  private int semester;

  @OneToOne
  @JoinColumn(name = "code_of_specialty", updatable = false, insertable = false)
  private Specialties specialties;

  public Specialties getSpecialties() {
    return specialties;
  }

  public void setSpecialties(Specialties specialties) {
    this.specialties = specialties;
  }

  public String getCodeOfSpecialty() {
    return codeOfSpecialty;
  }

  public void setCodeOfSpecialty(String codeOfSpecialty) {
    this.codeOfSpecialty = codeOfSpecialty;
  }


  public int getIdOfDiscipline() {
    return idOfDiscipline;
  }

  public void setIdOfDiscipline(int idOfDiscipline) {
    this.idOfDiscipline = idOfDiscipline;
  }


  public int getSemester() {
    return semester;
  }

  public void setSemester(int semester) {
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
