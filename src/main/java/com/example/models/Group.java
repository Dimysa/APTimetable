package com.example.models;

import com.example.models.id.GroupId;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "groups")
@IdClass(GroupId.class)
public class Group {

    @Id
    @Column(name = "code_of_specialty")
    private String codeOfSpecialty;

    @Id
    @Column(name = "number_of_group")
    private int group;

    @Id
    private int semester;

    @OneToMany(mappedBy = "obj", fetch = FetchType.EAGER)
    @JsonIgnore
    private Collection<Subgroup> subgroups;

    @ManyToOne
    @JoinColumn(name = "code_of_specialty", insertable = false, updatable = false,
            foreignKey = @ForeignKey(name = "group_table_code_of_specialty_fkey"))
    @JsonIgnore
    private Specialties specialties;

    public Group() {
    }

    public Specialties getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Specialties specialties) {
        this.specialties = specialties;
    }

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
}
