package com.example.persistence.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
public class ResourceDTO implements Serializable {

    private Long id;
    private String name;
    private List<CapacityDTO> capacity;
    private List<ZoneDTO> zone;
}
