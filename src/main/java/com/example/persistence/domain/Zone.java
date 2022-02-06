package com.example.persistence.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.UUID;

@Entity
@Getter @Setter
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "zone_gen_seq")
    @SequenceGenerator(name = "zone_gen_seq", sequenceName = "zone_seq")
    private Long id;

    private UUID name;
}
