package com.example.persistence.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "res_seq_gen")
    @SequenceGenerator(name = "res_seq_gen", sequenceName = "res_seq")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "resource")
//    @JoinColumn(name = "resource_id", referencedColumnName = "id")
    private List<Capacity> capacities = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "resource_id", referencedColumnName = "id")
    private Set<Zone> zones = new HashSet<>();

}
