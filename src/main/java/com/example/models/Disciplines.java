package com.example.models;

import javax.persistence.*;

@Entity
@Table(name = "disciplines")
public class Disciplines {

  @Id @GeneratedValue
  private int id;
  @Column(name = "name_of_discipline", nullable = false)
  private String nameOfDiscipline;


  public int getId() {
    return id;
  }

  public void setId(int id) {
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
