package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "type_of_auditoriums")
public class TypeOfAuditorium {

  @Id
  @Column(name = "short_name_of_auditorium")
  private String shortNameOfAuditorium;
  @Column(name = "full_name_of_auditorium")
  private String fullNameOfAuditorium;

  public String getShortNameOfAuditorium() {
    return shortNameOfAuditorium;
  }

  public void setShortNameOfAuditorium(String shortNameOfAuditorium) {
    this.shortNameOfAuditorium = shortNameOfAuditorium;
  }

  public String getFullNameOfAuditorium() {
    return fullNameOfAuditorium;
  }

  public void setFullNameOfAuditorium(String fullNameOfAuditorium) {
    this.fullNameOfAuditorium = fullNameOfAuditorium;
  }

  public TypeOfAuditorium() {
  }
}
