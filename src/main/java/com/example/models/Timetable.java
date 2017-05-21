package com.example.models;

import javax.persistence.*;

@Entity
@Table(name = "timetable")
public class Timetable {

  @Id
  @SequenceGenerator(name="timetable", sequenceName = "timetable_id_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "timetable")
  private Integer id;
  @Column(name = "id_of_calendar")
  private Integer calendarId;
  @Column(name = "number_of_auditorium")
  private String numberOfAuditorium;
  @Column(name = "id_of_discipline")
  private Integer idOfDiscipline;
  @Column(name = "short_name_of_load")
  private String typeOfLoad;
  @Column(name = "code_of_specialty")
  private String codeOfSpecialty;
  @Column(name = "number_of_group")
  private Integer group;
  @Column(name = "number_of_subgroup")
  private Integer subgroup;
  private Integer semester;
  @Column(name = "id_of_teacher")
  private Integer idOfTeacher;

  public Integer getCalendarId() {
    return calendarId;
  }

  public void setCalendarId(Integer calendarId) {
    this.calendarId = calendarId;
  }

  public Integer getSemester() {
    return semester;
  }

  public void setSemester(Integer semester) {
    this.semester = semester;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNumberOfAuditorium() {
    return numberOfAuditorium;
  }

  public void setNumberOfAuditorium(String numberOfAuditorium) {
    this.numberOfAuditorium = numberOfAuditorium;
  }

  public Integer getIdOfDiscipline() {
    return idOfDiscipline;
  }

  public void setIdOfDiscipline(Integer idOfDiscipline) {
    this.idOfDiscipline = idOfDiscipline;
  }

  public String getTypeOfLoad() {
    return typeOfLoad;
  }

  public void setTypeOfLoad(String typeOfLoad) {
    this.typeOfLoad = typeOfLoad;
  }

  public String getCodeOfSpecialty() {
    return codeOfSpecialty;
  }

  public void setCodeOfSpecialty(String codeOfSpecialty) {
    this.codeOfSpecialty = codeOfSpecialty;
  }

  public Integer getGroup() {
    return group;
  }

  public void setGroup(Integer group) {
    this.group = group;
  }

  public Integer getSubgroup() {
    return subgroup;
  }

  public void setSubgroup(Integer subgroup) {
    this.subgroup = subgroup;
  }

  public Integer getIdOfTeacher() {
    return idOfTeacher;
  }

  public void setIdOfTeacher(Integer idOfTeacher) {
    this.idOfTeacher = idOfTeacher;
  }

  public Timetable(Timetable timetable) {
    this.calendarId = timetable.getCalendarId();
    this.numberOfAuditorium = timetable.getNumberOfAuditorium();
    this.idOfDiscipline = timetable.getIdOfDiscipline();
    this.typeOfLoad = timetable.getTypeOfLoad();
    this.codeOfSpecialty = timetable.getCodeOfSpecialty();
    this.group = timetable.getGroup();
    this.subgroup = timetable.getSubgroup();
    this.semester = timetable.getSemester();
    this.idOfTeacher = timetable.getIdOfTeacher();
  }

  public void update(Timetable timetable) {
    if(timetable.getCalendarId() != null)
      this.calendarId = timetable.getCalendarId();
    if(timetable.getNumberOfAuditorium() != null)
      this.numberOfAuditorium = timetable.getNumberOfAuditorium();
    if(timetable.getIdOfDiscipline() != null)
      this.idOfDiscipline = timetable.getIdOfDiscipline();
    if(timetable.getTypeOfLoad() != null)
      this.typeOfLoad = timetable.getTypeOfLoad();
    if(timetable.getCodeOfSpecialty() != null)
      this.codeOfSpecialty = timetable.getCodeOfSpecialty();
    if(timetable.getGroup() != null)
      this.group = timetable.getGroup();
    if(timetable.getSubgroup() != null)
      this.subgroup = timetable.getSubgroup();
    if(timetable.getSemester() != null)
      this.semester = timetable.getSemester();
    if(timetable.getIdOfTeacher() != null)
      this.idOfTeacher = timetable.getIdOfTeacher();
  }

  public Timetable() {
  }
}
