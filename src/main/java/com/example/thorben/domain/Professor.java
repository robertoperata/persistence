package com.example.thorben.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import java.util.List;

@Entity
@Table(name = "professor")
@Getter @Setter
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prof_seq_gen")
    @SequenceGenerator(name = "prof_seq_gen", sequenceName = "prof_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "professor")
    private List<Course> courses;

    @Version
    @Column(name = "OPT_LOCK")
    private long version;

    public void addCourse(Course course) {
        course.setProfessor(this);
    }

    public void removeCourse(Course course) {
        course.setProfessor(null);
    }

}