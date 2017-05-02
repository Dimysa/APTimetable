package com.example.models;

import com.example.models.id.GroupId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "group_table")
@IdClass(GroupId.class)
public class Group {

  @Id
  @Column(name = "code_of_specialty")
  private String codeOfSpecialty;

  @Id
  @Column(name = "group_num")
  private int group;

  @Id
  private int semester;

  @OneToMany(mappedBy = "obj", fetch = FetchType.EAGER)
  @JsonManagedReference
  private Collection<Subgroup> subgroups;


  public Collection<Subgroup> getSubgroups() {
    return this.subgroups;
  }

  public void setSubgroups(Collection<Subgroup> subgroups) {
    this.subgroups = subgroups;
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

  public Group() {
  }
}
