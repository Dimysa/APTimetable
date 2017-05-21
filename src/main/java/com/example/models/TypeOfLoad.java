package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "type_of_loads")
public class TypeOfLoad {

  @Id
  @Column(name = "short_name_of_load")
  private String shortNameOfLoad;
  @Column(name = "full_name_of_load", nullable = false)
  private String fullNameOfLoad;

  public String getShortNameOfLoad() {
    return shortNameOfLoad;
  }

  public void setShortNameOfLoad(String shortNameOfLoad) {
    this.shortNameOfLoad = shortNameOfLoad;
  }

  public String getFullNameOfLoad() {
    return fullNameOfLoad;
  }

  public void setFullNameOfLoad(String fullNameOfLoad) {
    this.fullNameOfLoad = fullNameOfLoad;
  }

  public TypeOfLoad() {
    super();
  }

  @Override
  public String toString() {
    return "TypeOfLoad{" +
            "shortNameOfLoad='" + shortNameOfLoad + '\'' +
            ", fullNameOfLoad='" + fullNameOfLoad + '\'' +
            '}';
  }
}
