package com.example.persistence.controller;

import com.example.persistence.domain.Resource;
import com.example.persistence.service.ResourceService;
import com.example.persistence.service.dto.ResourceDTO;
import com.example.persistence.service.mapper.ResourceMapper;
import lombok.AllArgsConstructor;
import org.apache.coyote.Request;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@RestController
@RequestMapping(path = "/resource")
@AllArgsConstructor
public class ResourceController {

    private final ResourceMapper resourceMapper;
    private final ResourceService service;

    @PostMapping
    public ResponseEntity<ResourceDTO> save(@RequestBody ResourceDTO dto, HttpServletRequest req) {

        Resource entity = resourceMapper.toEntity(dto);
        Resource save = service.save(entity);
        String path = req.getServletPath();
        return ResponseEntity.created(URI.create(String.format("%s/%d", path, save.getId()))).body(resourceMapper.toDto(save));
    }


}
