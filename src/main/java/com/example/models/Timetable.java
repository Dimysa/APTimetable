package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Timetable {

  @Id
  private int id;
  
  private String day;
  @Column(name = "id_class")
  private int idClass;
  @Column(name = "number_of_week")
  private int numberOfWeek;
  @Column(name = "number_of_auditorium")
  private String numberOfAuditorium;
  @Column(name = "id_of_discipline")
  private int idOfDiscipline;
  @Column(name = "type_of_load")
  private String typeOfLoad;
  @Column(name = "id_of_stream")
  private int idOfStream;
  @Column(name = "code_of_specialty")
  private String codeOfSpecialty;
  @Column(name = "group_num")
  private int group;
  @Column(name = "subgroup_num")
  private int subgroup;
  @Column(name = "id_of_teacher")
  private int idOfTeacher;
 
  public int getId() {
      return id;
  }

  public void setId(int id) {
      this.id = id;
  }


  public String getDay() {
    return day;
  }

  public void setDay(String day) {
    this.day = day;
  }

  public int getIdClass() {
    return idClass;
  }

  public void setIdClass(int idClass) {
    this.idClass = idClass;
  }

  public int getNumberOfWeek() {
    return numberOfWeek;
  }

  public void setNumberOfWeek(int numberOfWeek) {
    this.numberOfWeek = numberOfWeek;
  }

  public String getNumberOfAuditorium() {
    return numberOfAuditorium;
  }

  public void setNumberOfAuditorium(String numberOfAuditorium) {
    this.numberOfAuditorium = numberOfAuditorium;
  }

  public int getIdOfDiscipline() {
    return idOfDiscipline;
  }

  public void setIdOfDiscipline(int idOfDiscipline) {
    this.idOfDiscipline = idOfDiscipline;
  }

  public String getTypeOfLoad() {
    return typeOfLoad;
  }

  public void setTypeOfLoad(String typeOfLoad) {
    this.typeOfLoad = typeOfLoad;
  }

  public int getIdOfStream() {
    return idOfStream;
  }

  public void setIdOfStream(int idOfStream) {
    this.idOfStream = idOfStream;
  }

  public String getCodeOfSpecialty() {
    return codeOfSpecialty;
  }

  public void setCodeOfSpecialty(String codeOfSpecialty) {
    this.codeOfSpecialty = codeOfSpecialty;
  }

  public int getGroup() {
    return group;
  }

  public void setGroup(int group) {
    this.group = group;
  }

  public int getSubgroup() {
    return subgroup;
  }

  public void setSubgroup(int subgroup) {
    this.subgroup = subgroup;
  }

  public int getIdOfTeacher() {
    return idOfTeacher;
  }

  public void setIdOfTeacher(int idOfTeacher) {
    this.idOfTeacher = idOfTeacher;
  }
}
