package com.example.models;

import javax.persistence.*;

@Entity
@Table(name = "pulpits")
public class Pulpits {
  @Id
  @SequenceGenerator(name="pul", sequenceName = "pulpits_id_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pul")
  private int id;
  @Column(name = "short_name_of_pulpit")
  private String shortNameOfPulpit;
  @Column(name = "full_name_of_pulpit")
  private String fullNameOfPulput;
  @Column(name = "id_of_faculty")
  private int idOfFaculty;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getShortNameOfPulpit() {
    return shortNameOfPulpit;
  }

  public void setShortNameOfPulpit(String shortNameOfPulpit) {
    this.shortNameOfPulpit = shortNameOfPulpit;
  }

  public String getFullNameOfPulput() {
    return fullNameOfPulput;
  }

  public void setFullNameOfPulput(String fullNameOfPulput) {
    this.fullNameOfPulput = fullNameOfPulput;
  }

  public int getIdOfFaculty() {
    return idOfFaculty;
  }

  public void setIdOfFaculty(int idOfFaculty) {
    this.idOfFaculty = idOfFaculty;
  }
}
