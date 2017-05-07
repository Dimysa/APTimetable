package com.example.models;

import javax.persistence.*;

@Entity
@Table(name = "timetable")
public class Timetable {

  @Id
  @SequenceGenerator(name="timetable", sequenceName = "timetable_id_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "timetable")
  private Integer id;

  private java.sql.Date date;
  @Column(name = "id_class")
  private Integer idClass;
  @Column(name = "number_of_week")
  private Integer numberOfWeek;
  @Column(name = "number_of_auditorium")
  private String numberOfAuditorium;
  @Column(name = "id_of_discipline")
  private Integer idOfDiscipline;
  @Column(name = "typeOfLoad")
  private String typeOfLoad;
  @Column(name = "id_of_stream")
  private Integer idOfStream;
  @Column(name = "code_of_specialty")
  private String codeOfSpecialty;
  @Column(name = "group_num")
  private Integer groupNum;
  private Integer subgroup;
  private Integer semester;
  @Column(name = "id_of_teacher")
  private Integer idOfTeacher;

  @OneToOne
  @JoinColumn(name = "id_of_stream", updatable = false, insertable = false)
  private Stream stream;

  public Stream getStream() {
    return stream;
  }

  public void setStream(Stream stream) {
    this.stream = stream;
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

  public java.sql.Date getDate() {
    return date;
  }

  public void setDate(java.sql.Date date) {
    this.date = date;
  }

  public Integer getIdClass() {
    return idClass;
  }

  public void setIdClass(Integer idClass) {
    this.idClass = idClass;
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

  public Integer getIdOfStream() {
    return idOfStream;
  }

  public void setIdOfStream(Integer idOfStream) {
    this.idOfStream = idOfStream;
  }

  public String getCodeOfSpecialty() {
    return codeOfSpecialty;
  }

  public void setCodeOfSpecialty(String codeOfSpecialty) {
    this.codeOfSpecialty = codeOfSpecialty;
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

  public Integer getIdOfTeacher() {
    return idOfTeacher;
  }

  public void setIdOfTeacher(Integer idOfTeacher) {
    this.idOfTeacher = idOfTeacher;
  }
}
