package com.example.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "stream")
public class Stream {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  private Long semester;

  @OneToMany(mappedBy = "stream", fetch = FetchType.EAGER)
  @JsonManagedReference
  private Collection<Substream> substreams;

  public Collection<Substream> getSubstreams() {
    return substreams;
  }

  public void setSubstreams(Collection<Substream> substreams) {
    this.substreams = substreams;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getSemester() {
    return semester;
  }

  public void setSemester(Long semester) {
    this.semester = semester;
  }

  public Stream() {
  }
}
