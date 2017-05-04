package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Auditoriums {

  @Id
  @Column(name = "number_of_auditorium")
  private String numberOfAuditorium;
  @NotNull
  private int capacity;
  @Column(name = "short_name_of_auditorium", nullable = false)
  private String shortNameOfAuditorium;


  public String getNumber() {
    return numberOfAuditorium;
  }

  public void setNumber(String numberOfAuditorium) {
    this.numberOfAuditorium = numberOfAuditorium;
  }


  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }


  public String getShortNameOfAuditorium() {
    return shortNameOfAuditorium;
  }

  public void setShortNameOfAuditorium(String shortNameOfAuditorium) {
    this.shortNameOfAuditorium = shortNameOfAuditorium;
  }

  public Auditoriums() {
  }

  @Override
  public String toString() {
    return "Auditoriums{" +
            "number='" + numberOfAuditorium + '\'' +
            ", capacity=" + capacity +
            ", shortNameOfAuditorium='" + shortNameOfAuditorium + '\'' +
            '}';
  }
}
