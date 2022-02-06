package com.example.persistence.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ZoneDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
}
