package com.example.models;

import javax.persistence.*;

@Entity
@Table(name = "teachers")
public class Teachers {
  @Id
  @SequenceGenerator(name="teach", sequenceName = "teachers_id_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teach")
  private int id;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "middle_name")
  private String middleName;
  @Column(name = "id_of_pulpit")
  private int idOfPulpit;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public int getIdOfPulpit() {
    return idOfPulpit;
  }

  public void setIdOfPulpit(int idOfPulpit) {
    this.idOfPulpit = idOfPulpit;
  }
}
