package com.example.thorben.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.Set;

@Entity
@Getter @Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stud_seq_gen")
    @SequenceGenerator(name = "stud_seq_gen", sequenceName = "stud_seq")
    private Long id;

    private String firstName;

    private String lastName;

    private StudentStatus state;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "students")
    private Set<Course> courses = new java.util.LinkedHashSet<>();

    public void addCourse(Course course) {
        this.courses.add(course);
        course.getStudents().add(this);
    }

    public void removeCourse(Course course) {
        this.courses.remove(course);
        course.getStudents().remove(this);
    }
}
