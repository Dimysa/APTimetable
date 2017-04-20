package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Disciplines {

  @Id @GeneratedValue
  private long id;
  @Column(name = "name_of_discipline", nullable = false)
  private String nameOfDiscipline;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getNameOfDiscipline() {
    return nameOfDiscipline;
  }

  public void setNameOfDiscipline(String nameOfDiscipline) {
    this.nameOfDiscipline = nameOfDiscipline;
  }

  public Disciplines() {
  }

  @Override
  public String toString() {
    return "Disciplines{" +
            "id=" + id +
            ", nameOfDiscipline='" + nameOfDiscipline + '\'' +
            '}';
  }
}
