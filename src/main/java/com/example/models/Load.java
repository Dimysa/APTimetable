package com.example.models;

import com.example.models.id.LoadId;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "load")
@IdClass(LoadId.class)
public class Load {
  @Id
  @Column(name = "code_of_specialty")
  private String codeOfSpecialty;
  @Id
  @Column(name = "id_of_discipline")
  private Integer idOfDiscipline;
  @Id
  @Column(name = "semester")
  private Integer semester;
  @Id
  @Column(name = "short_name_of_load")
  private String shortNameOfLoad;
  @Id
  @Column(name = "count_of_hours")
  private Integer numberOfHours;
  @ManyToOne
  @JoinColumns(value = {
          @JoinColumn(name = "code_of_specialty", insertable = false, updatable = false),
          @JoinColumn(name = "id_of_discipline", insertable = false, updatable = false),
          @JoinColumn(name = "semester", insertable = false, updatable = false)
  }, foreignKey = @ForeignKey(name = "load_code_of_specialty_fkey"))
  @JsonIgnore
  private AcademicPlan academicPlan;

  public AcademicPlan getAcademicPlan() {
    return academicPlan;
  }

  public void setAcademicPlan(AcademicPlan academicPlan) {
    this.academicPlan = academicPlan;
  }

  public String getCodeOfSpecialty() {
    return codeOfSpecialty;
  }

  public void setCodeOfSpecialty(String codeOfSpecialty) {
    this.codeOfSpecialty = codeOfSpecialty;
  }

  public Integer getIdOfDiscipline() {
    return idOfDiscipline;
  }

  public void setIdOfDiscipline(Integer idOfDiscipline) {
    this.idOfDiscipline = idOfDiscipline;
  }

  public Integer getSemester() {
    return semester;
  }

  public void setSemester(Integer semester) {
    this.semester = semester;
  }

  public String getShortNameOfLoad() {
    return shortNameOfLoad;
  }

  public void setShortNameOfLoad(String shortNameOfLoad) {
    this.shortNameOfLoad = shortNameOfLoad;
  }

  public Integer getNumberOfHours() {
    return numberOfHours;
  }

  public void setNumberOfHours(Integer numberOfHours) {
    this.numberOfHours = numberOfHours;
  }

  public Load() {
  }
}
