package com.example.models;


import com.example.models.id.AcademicPlanId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

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
  @JoinColumn(name = "code_of_specialty", updatable = false, insertable = false, foreignKey = @ForeignKey(name = "academic_plan_code_of_specialty_fkey"))
  @JsonIgnore
  private Specialties specialty;
  @OneToOne
  @JoinColumn(name = "id_of_discipline", updatable = false, insertable = false, foreignKey = @ForeignKey(name = "academic_plan_id_of_discipline_fkey"))
  @JsonIgnore
  private Disciplines discipline;
  @OneToMany(mappedBy = "academicPlan")
  @LazyCollection(LazyCollectionOption.FALSE)
  Collection<Load> loads;

  public Collection<Load> getLoads() {
    return loads;
  }

  public void setLoads(Collection<Load> loads) {
    this.loads = loads;
  }

  public Disciplines getDiscipline() {
    return discipline;
  }

  public void setDiscipline(Disciplines discipline) {
    this.discipline = discipline;
  }

  public Specialties getSpecialty() {
    return specialty;
  }

  public void setSpecialty(Specialties specialty) {
    this.specialty = specialty;
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
