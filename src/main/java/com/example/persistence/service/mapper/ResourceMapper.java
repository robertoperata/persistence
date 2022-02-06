package com.example.persistence.service.mapper;

import com.example.persistence.domain.Resource;
import com.example.persistence.service.dto.ResourceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring", uses = {CapacityMapper.class, })
public interface ResourceMapper extends EntityMapper<Resource, ResourceDTO> {

    ResourceDTO toDto(Resource entity);

    @Mapping(source = "capacity", target = "capacities")
    @Mapping(source = "zone", target = "zones")
    Resource toEntity(ResourceDTO dto);

    default UUID map(String value){
        return UUID.fromString(value);
    }
}
