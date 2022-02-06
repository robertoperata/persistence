package com.example.persistence.service.mapper;

import com.example.persistence.domain.Capacity;
import com.example.persistence.service.dto.CapacityDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CapacityMapper extends EntityMapper<Capacity, CapacityDTO> {

    Capacity toEntity(CapacityDTO capacityDTO);

    CapacityDTO toDto(Capacity capacity);

}
