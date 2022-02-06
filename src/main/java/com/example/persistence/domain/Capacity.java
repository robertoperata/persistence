package com.example.persistence.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Getter @Setter
@Entity
public class Capacity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cap_seq_gen")
    @SequenceGenerator(name = "cap_seq_gen", sequenceName = "cap_seq")
    private Long id;

    @Column(length = 20)
    private String name;

    private Integer capacity;

    @ManyToOne
    private Resource resource;

}
