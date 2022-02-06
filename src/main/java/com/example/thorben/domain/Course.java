package com.example.thorben.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "course")
@Getter @Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cour_seq_gen")
    @SequenceGenerator(name = "cour_seq_gen", sequenceName = "cour_seq")
    private Long id;

    private String name;

    private LocalDate startDate;

    private LocalDate endDate;

    @ManyToOne
//    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToMany
    private Set<Student> students = new HashSet<>();

    public void setProfessor(Professor professor) {
        if(this.professor != null) {
            this.professor.getCourses().remove(this);
        }
        this.professor = professor;
        if(professor != null) {
            this.professor.getCourses().add(this);
        }
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.getCourses().add(this);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
        student.getCourses().remove(this);
    }



}