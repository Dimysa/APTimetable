package com.example.models;

import javax.persistence.*;

@Entity
@Table(name = "disciplines")
public class Disciplines {

  @Id
  @SequenceGenerator(name="disc", sequenceName = "disciplines_id_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disc")
  private Integer id;
  @Column(name = "discipline", nullable = false)
  private String nameOfDiscipline;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
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
