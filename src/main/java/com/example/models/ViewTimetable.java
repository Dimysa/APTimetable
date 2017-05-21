package com.example.models;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@org.hibernate.annotations.Immutable
public class ViewTimetable {

  @Id
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
  @Column(name = "calendar_date")
  private java.sql.Date date;
  @Column(name = "time")
  private String time;
  @Column(name = "number_of_week")
  private Integer numberOfWeek;
  @Column(name = "number_of_auditorium")
  private String numberOfAuditorium;
  @Column(name = "discipline")
  private String nameOfDiscipline;
  @Column(name = "full_name_of_load")
  private String fullNameOfLoad;
  @Column(name = "full_name_of_specialty")
  private String fullNameOfSpecialty;
  @Column(name = "number_of_group")
  private Integer groupNum;
  @Column(name = "number_of_subgroup")
  private Integer subgroup;
  private Integer semester;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "middle_name")
  private String middleName;

  public Integer getSemester() {
    return semester;
  }

  public void setSemester(Integer semester) {
    this.semester = semester;
  }

  public java.sql.Date getDate() {
    return date;
  }

  public void setDate(java.sql.Date date) {
    this.date = date;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public Integer getNumberOfWeek() {
    return numberOfWeek;
  }

  public void setNumberOfWeek(Integer numberOfWeek) {
    this.numberOfWeek = numberOfWeek;
  }

  public String getNumberOfAuditorium() {
    return numberOfAuditorium;
  }

  public void setNumberOfAuditorium(String numberOfAuditorium) {
    this.numberOfAuditorium = numberOfAuditorium;
  }

  public String getNameOfDiscipline() {
    return nameOfDiscipline;
  }

  public void setNameOfDiscipline(String nameOfDiscipline) {
    this.nameOfDiscipline = nameOfDiscipline;
  }

  public String getFullNameOfLoad() {
    return fullNameOfLoad;
  }

  public void setFullNameOfLoad(String fullNameOfLoad) {
    this.fullNameOfLoad = fullNameOfLoad;
  }

  public String getFullNameOfSpecialty() {
    return fullNameOfSpecialty;
  }

  public void setFullNameOfSpecialty(String fullNameOfSpecialty) {
    this.fullNameOfSpecialty = fullNameOfSpecialty;
  }

  public Integer getGroupNum() {
    return groupNum;
  }

  public void setGroupNum(Integer groupNum) {
    this.groupNum = groupNum;
  }

  public Integer getSubgroup() {
    return subgroup;
  }

  public void setSubgroup(Integer subgroup) {
    this.subgroup = subgroup;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public ViewTimetable() {
  }
}
