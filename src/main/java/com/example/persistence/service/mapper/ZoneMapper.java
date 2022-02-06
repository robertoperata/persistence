package com.example.persistence.service.mapper;

import com.example.persistence.domain.Zone;
import com.example.persistence.service.dto.ZoneDTO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ZoneMapper extends EntityMapper<Zone, ZoneDTO> {

   @Mapping(target = "name", expression = "java(java.util.UUID.fromString(zoneDTO.getName()))")
   Zone toEntity(ZoneDTO zoneDTO);

   @Mapping(target = "name", expression = "java(zone.getName().toString())")
   ZoneDTO toDto(Zone zone);


}
