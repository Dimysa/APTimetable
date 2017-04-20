package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Auditoriums {

  @Id
  private String number;
  @NotNull
  private long capacity;
  @Column(name = "short_name_of_auditorium", nullable = false)
  private String shortNameOfAuditorium;


  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }


  public long getCapacity() {
    return capacity;
  }

  public void setCapacity(long capacity) {
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
            "number='" + number + '\'' +
            ", capacity=" + capacity +
            ", shortNameOfAuditorium='" + shortNameOfAuditorium + '\'' +
            '}';
  }
}
