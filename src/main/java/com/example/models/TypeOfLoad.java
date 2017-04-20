package com.example.models;

import org.springframework.context.annotation.Primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class TypeOfLoad {

  @Id
  private String short_name_of_load;
  @NotNull
  private String full_name_of_load;

  public String getShort_name_of_load() {
    return short_name_of_load;
  }

  public void setShort_name_of_load(String short_name_of_load) {
    this.short_name_of_load = short_name_of_load;
  }

  public String getFull_name_of_load() {
    return full_name_of_load;
  }

  public void setFull_name_of_load(String full_name_of_load) {
    this.full_name_of_load = full_name_of_load;
  }

  public TypeOfLoad() {
    super();
  }

  @Override
  public String toString() {
    return "TypeOfLoad{" +
            "short_name_of_load='" + short_name_of_load + '\'' +
            ", full_name_of_load='" + full_name_of_load + '\'' +
            '}';
  }
}
