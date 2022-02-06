package com.example.persistence.service;

import com.example.persistence.domain.Resource;
import com.example.persistence.repository.ResourceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;

@Service
@AllArgsConstructor
public class ResourceService {

    private final ResourceRepository repository;

    public Resource save(Resource entity) {
        return repository.save(entity);
    }


}
