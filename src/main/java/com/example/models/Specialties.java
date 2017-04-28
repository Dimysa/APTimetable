package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "specialties")
public class Specialties {

  @Id
  @Column(name = "code_of_specialty")
  private String codeOfSpecialty;

  @Column(name = "short_name_of_specialty")
  private String shortNameOfSpecialty;

  @Column(name = "full_name_of_specialty")
  private String fullNameOfSpecialty;

  @Column(name = "id_of_faculty")
  private int idOfFaculty;



  public String getCodeOfSpecialty() {
    return codeOfSpecialty;
  }

  public void setCodeOfSpecialty(String codeOfSpecialty) {
    this.codeOfSpecialty = codeOfSpecialty;
  }

  public String getShortNameOfSpecialty() {
    return shortNameOfSpecialty;
  }

  public void setShortNameOfSpecialty(String shortNameOfSpecialty) {
    this.shortNameOfSpecialty = shortNameOfSpecialty;
  }

  public String getFullNameOfSpecialty() {
    return fullNameOfSpecialty;
  }

  public void setFullNameOfSpecialty(String fullNameOfSpecialty) {
    this.fullNameOfSpecialty = fullNameOfSpecialty;
  }

  public int getIdOfFaculty() {
    return idOfFaculty;
  }

  public void setIdOfFaculty(int idOfFaculty) {
    this.idOfFaculty = idOfFaculty;
  }

  public Specialties() {
  }
}
