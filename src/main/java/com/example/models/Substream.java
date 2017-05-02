package com.example.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "substream")
public class Substream {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_key")
  private int idKey;

  @Column(name = "id")
  private int id;

  @Column(name = "code_of_specialty")
  private String codeOfSpecialty;

  @Column(name = "group_num")
  private int group;

  private int semester;
  @Column(name = "id_of_discipline")
  private int idOfDiscipline;

  @ManyToOne
  @JoinColumn(name = "id", insertable = false, updatable = false)
  @JsonBackReference
  private Stream stream;

  public Stream getStream() {
    return stream;
  }

  public void setStream(Stream stream) {
    this.stream = stream;
  }

  public int getIdKey() {
    return idKey;
  }

  public void setIdKey(int idKey) {
    this.idKey = idKey;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCodeOfSpecialty() {
    return codeOfSpecialty;
  }

  public void setCodeOfSpecialty(String codeOfSpecialty) {
    this.codeOfSpecialty = codeOfSpecialty;
  }

  public int getGroup() {
    return group;
  }

  public void setGroup(int group) {
    this.group = group;
  }

  public int getSemester() {
    return semester;
  }

  public void setSemester(int semester) {
    this.semester = semester;
  }

  public int getIdOfDiscipline() {
    return idOfDiscipline;
  }

  public void setIdOfDiscipline(int idOfDiscipline) {
    this.idOfDiscipline = idOfDiscipline;
  }

  public Substream() {
  }
}
