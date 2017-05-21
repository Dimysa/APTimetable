package com.example.models;

import javax.persistence.*;

@Entity
@Table(name = "calendar")
public class Calendar {

  @Id
  @SequenceGenerator(name="cal", sequenceName = "calendar_id_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cal")
  private Integer id;
  @Column(name = "calendar_date")
  private java.sql.Date calendarDate;
  @Column(name = "number_of_week")
  private Integer numberOfWeek;
  @Column(name = "id_of_time")
  private Integer idClass;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public java.sql.Date getCalendarDate() {
    return calendarDate;
  }

  public void setCalendarDate(java.sql.Date calendarDate) {
    this.calendarDate = calendarDate;
  }

  public Integer getNumberOfWeek() {
    return numberOfWeek;
  }

  public void setNumberOfWeek(Integer numberOfWeek) {
    this.numberOfWeek = numberOfWeek;
  }

  public Integer getIdClass() {
    return idClass;
  }

  public void setIdClass(Integer idClass) {
    this.idClass = idClass;
  }

  public Calendar() {
  }
}
