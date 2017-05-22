package com.example.models;

import com.example.models.id.SubgroupId;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "subgroups")
@IdClass(SubgroupId.class)
public class Subgroup {
  @Id
  @Column(name = "code_of_specialty")
  private String codeOfSpecialty;
  @Id
  @Column(name = "number_of_group")
  private int group;
  @Id
  private int semester;
  @Id
  @Column(name = "number_of_subgroup", nullable = false)
  private int subgroup;
  @Column(name = "count_of_students")
  private int countOfStudents;

  @ManyToOne()
  @JoinColumns(foreignKey = @ForeignKey(name = "subgroup_code_of_specialty_fkey"), value = {
          @JoinColumn(name = "code_of_specialty", nullable = false, insertable = false, updatable = false),
          @JoinColumn(name = "number_of_group", nullable = false, insertable = false, updatable = false),
          @JoinColumn(name = "semester", nullable = false, insertable = false, updatable = false)
  })
  @JsonIgnore
  private Group obj;

  public Group getObj() {
    return this.obj;
  }

  public void setObj(Group obj) {
    this.obj = obj;
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

  public int getSubgroup() {
    return subgroup;
  }

  public void setSubgroup(int subgroup) {
    this.subgroup = subgroup;
  }

  public int getCountOfStudents() {
    return countOfStudents;
  }

  public void setCountOfStudents(int countOfStudents) {
    this.countOfStudents = countOfStudents;
  }

  public Subgroup() {
  }
}
