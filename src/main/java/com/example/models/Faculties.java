package com.example.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "faculties")
public class Faculties {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @NotNull
  private String short_Name_Of_Faculty;

  @NotNull
  private String full_Name_Of_Faculty;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getShort_Name_Of_Faculty() {
    return short_Name_Of_Faculty;
  }

  public void setShort_Name_Of_Faculty(String short_Name_Of_Faculty) {
    this.short_Name_Of_Faculty = short_Name_Of_Faculty;
  }


  public String getFull_Name_Of_Faculty() {
    return full_Name_Of_Faculty;
  }

  public void setFull_Name_Of_Faculty(String full_Name_Of_Faculty) {
    this.full_Name_Of_Faculty = full_Name_Of_Faculty;
  }

  public Faculties() {
    super();
  }

  @Override
  public String toString() {
    return "Faculties{" +
            "id=" + id +
            ", short_Name_Of_Faculty='" + short_Name_Of_Faculty + '\'' +
            ", full_Name_Of_Faculty='" + full_Name_Of_Faculty + '\'' +
            '}';
  }
}
