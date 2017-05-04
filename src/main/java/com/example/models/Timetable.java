package com.example.models;

import javax.persistence.*;

@Entity
@Table(name = "timetable")
public class Timetable {

  @Id
  @SequenceGenerator(name="timetable", sequenceName = "timetable_id_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "timetable")
  private Long id;

  private java.sql.Date date;
  @Column(name = "id_class")
  private Long idClass;
  @Column(name = "number_of_week")
  private Long numberOfWeek;
  @Column(name = "number_of_auditorium")
  private String numberOfAuditorium;
  @Column(name = "id_of_discipline")
  private Long idOfDiscipline;
  @Column(name = "typeOfLoad")
  private String typeOfLoad;
  @Column(name = "id_of_stream")
  private Long idOfStream;
  @Column(name = "code_of_specialty")
  private String codeOfSpecialty;
  @Column(name = "group_num")
  private Long groupNum;
  private Long subgroup;
  private Long semester;
  @Column(name = "id_of_teacher")
  private Long idOfTeacher;

  @OneToOne
  @JoinColumn(name = "id_of_stream", updatable = false, insertable = false)
  private Stream stream;

  public Stream getStream() {
    return stream;
  }

  public void setStream(Stream stream) {
    this.stream = stream;
  }

  public Long getSemester() {
    return semester;
  }

  public void setSemester(Long semester) {
    this.semester = semester;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public java.sql.Date getDate() {
    return date;
  }

  public void setDate(java.sql.Date date) {
    this.date = date;
  }

  public Long getIdClass() {
    return idClass;
  }

  public void setIdClass(Long idClass) {
    this.idClass = idClass;
  }

  public Long getNumberOfWeek() {
    return numberOfWeek;
  }

  public void setNumberOfWeek(Long numberOfWeek) {
    this.numberOfWeek = numberOfWeek;
  }

  public String getNumberOfAuditorium() {
    return numberOfAuditorium;
  }

  public void setNumberOfAuditorium(String numberOfAuditorium) {
    this.numberOfAuditorium = numberOfAuditorium;
  }

  public Long getIdOfDiscipline() {
    return idOfDiscipline;
  }

  public void setIdOfDiscipline(Long idOfDiscipline) {
    this.idOfDiscipline = idOfDiscipline;
  }

  public String getTypeOfLoad() {
    return typeOfLoad;
  }

  public void setTypeOfLoad(String typeOfLoad) {
    this.typeOfLoad = typeOfLoad;
  }

  public Long getIdOfStream() {
    return idOfStream;
  }

  public void setIdOfStream(Long idOfStream) {
    this.idOfStream = idOfStream;
  }

  public String getCodeOfSpecialty() {
    return codeOfSpecialty;
  }

  public void setCodeOfSpecialty(String codeOfSpecialty) {
    this.codeOfSpecialty = codeOfSpecialty;
  }

  public Long getGroupNum() {
    return groupNum;
  }

  public void setGroupNum(Long groupNum) {
    this.groupNum = groupNum;
  }

  public Long getSubgroup() {
    return subgroup;
  }

  public void setSubgroup(Long subgroup) {
    this.subgroup = subgroup;
  }

  public Long getIdOfTeacher() {
    return idOfTeacher;
  }

  public void setIdOfTeacher(Long idOfTeacher) {
    this.idOfTeacher = idOfTeacher;
  }
}
