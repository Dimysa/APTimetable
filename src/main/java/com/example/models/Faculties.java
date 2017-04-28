package com.example.models;

import javax.persistence.*;

@Entity
@Table(name = "faculties")
public class Faculties {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "short_name_of_faculty", nullable = false)
  private String shortNameOfFaculty;

  @Column(name = "full_name_of_faculty", nullable = false)
  private String fullNameOfFaculty;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getShortNameOfFaculty() {
    return shortNameOfFaculty;
  }

  public void setShortNameOfFaculty(String shortNameOfFaculty) {
    this.shortNameOfFaculty = shortNameOfFaculty;
  }


  public String getFullNameOfFaculty() {
    return fullNameOfFaculty;
  }

  public void setFullNameOfFaculty(String fullNameOfFaculty) {
    this.fullNameOfFaculty = fullNameOfFaculty;
  }

  public Faculties() {
    super();
  }

  @Override
  public String toString() {
    return "Faculties{" +
            "id=" + id +
            ", shortNameOfFaculty='" + shortNameOfFaculty + '\'' +
            ", fullNameOfFaculty='" + fullNameOfFaculty + '\'' +
            '}';
  }
}
