package com.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "faculties")
public class Faculties {

  @Id
  @SequenceGenerator(name="fac", sequenceName = "faculties_id_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fac")
  private int id;

  @Column(name = "short_name_of_faculty", nullable = false)
  private String shortNameOfFaculty;

  @Column(name = "full_name_of_faculty", nullable = false)
  private String fullNameOfFaculty;

  @OneToMany(mappedBy = "faculty", fetch = FetchType.EAGER)
  @JsonIgnore
  private Collection<Specialties> specialties;

  public Collection<Specialties> getSpecialties() {
    return specialties;
  }

  public void setSpecialties(Collection<Specialties> specialties) {
    this.specialties = specialties;
  }

  public void update(Faculties faculties) {
    this.id = faculties.getId();
    this.shortNameOfFaculty = faculties.getShortNameOfFaculty();
    this.fullNameOfFaculty = faculties.getFullNameOfFaculty();
  }

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
