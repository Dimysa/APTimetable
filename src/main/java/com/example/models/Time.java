package com.example.models;

import javax.persistence.*;

@Entity
@Table(name = "time")
public class Time {
  
  @Id
  @SequenceGenerator(name="timeseq", sequenceName = "time_id_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "timeseq")
  private Integer id;
  
  private String time;
  
  private Integer session;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public Integer getSession() {
    return session;
  }

  public void setSession(Integer session) {
    this.session = session;
  }

  public Time() {
  }
}
