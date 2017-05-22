package com.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;

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

  @ManyToOne
  @JoinColumn(name = "id_of_faculty", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "specialties_id_of_faculty_fkey"))
  @JsonIgnore
  private Faculties faculty;

  @OneToMany(mappedBy = "specialties")
  @LazyCollection(LazyCollectionOption.FALSE)
  @JsonIgnore
  private Collection<Group> groups;

  public Collection<Group> getGroups() {
    return groups;
  }

  public void setGroups(Collection<Group> groups) {
    this.groups = groups;
  }

  public Faculties getFaculty() {
    return faculty;
  }

  public void setFaculty(Faculties faculty) {
    this.faculty = faculty;
  }


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
