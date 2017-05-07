package com.example.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "stream")
public class Stream {

  @Id
  @SequenceGenerator(name="str", sequenceName = "stream_id_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "str")
  private Integer id;

  private String name;

  private Integer semester;

  @OneToMany(mappedBy = "stream", fetch = FetchType.EAGER)
  @JsonManagedReference
  private Collection<Substream> substreams;

  public Collection<Substream> getSubstreams() {
    return substreams;
  }

  public void setSubstreams(Collection<Substream> substreams) {
    this.substreams = substreams;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getSemester() {
    return semester;
  }

  public void setSemester(Integer semester) {
    this.semester = semester;
  }

  public Stream() {
  }
}
