package com.example.models;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@org.hibernate.annotations.Immutable
public class ViewTimetable {

  @Id
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  private java.sql.Date date;
  private Integer id_class;
  private Integer number_of_week;
  private String number;
  private String name_of_discipline;
  private String full_name_of_load;
  private String full_name_of_specialty;
  private Integer group_num;
  private Integer subgroup;
  private String last_name;
  private String first_name;
  private String middle_name;

  public java.sql.Date getDate() {
    return date;
  }

  public void setDate(java.sql.Date date) {
    this.date = date;
  }

  public Integer getId_class() {
    return id_class;
  }

  public void setId_class(Integer id_class) {
    this.id_class = id_class;
  }

  public Integer getNumber_of_week() {
    return number_of_week;
  }

  public void setNumber_of_week(Integer number_of_week) {
    this.number_of_week = number_of_week;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getName_of_discipline() {
    return name_of_discipline;
  }

  public void setName_of_discipline(String name_of_discipline) {
    this.name_of_discipline = name_of_discipline;
  }

  public String getFull_name_of_load() {
    return full_name_of_load;
  }

  public void setFull_name_of_load(String full_name_of_load) {
    this.full_name_of_load = full_name_of_load;
  }

  public String getFull_name_of_specialty() {
    return full_name_of_specialty;
  }

  public void setFull_name_of_specialty(String full_name_of_specialty) {
    this.full_name_of_specialty = full_name_of_specialty;
  }

  public Integer getGroup_num() {
    return group_num;
  }

  public void setGroup_num(Integer group_num) {
    this.group_num = group_num;
  }

  public Integer getSubgroup() {
    return subgroup;
  }

  public void setSubgroup(Integer subgroup) {
    this.subgroup = subgroup;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getMiddle_name() {
    return middle_name;
  }

  public void setMiddle_name(String middle_name) {
    this.middle_name = middle_name;
  }

  public ViewTimetable() {
  }
}
