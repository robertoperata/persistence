package com.example.persistence.domain;

import com.example.persistence.repository.CapacityRepository;
import com.example.persistence.repository.ResourceRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ResourceTest {

    @Autowired
    private ResourceRepository repository;

    @Autowired
    private CapacityRepository capacityRepository;

    @Test
    @DisplayName("List One-To-Many")
    public void checkListOneToMany() {
       Resource resource = new Resource();
       resource.setName("resource 1");

       List<Capacity> capacityList = new ArrayList<>();
       Capacity capacity1 = new Capacity();
       capacity1.setName("capacity one");
       capacityList.add(capacity1);
        Capacity capacity2 = new Capacity();
        capacity1.setName("capacity two");
        capacity1.setResource(resource);
        capacityList.add(capacity2);

        resource.setCapacities(capacityList);
        Resource save = repository.save(resource);
//        capacityRepository.save(capacity1);
//        capacityRepository.save(capacity2);

        Capacity capacity3 = new Capacity();
        capacity1.setName("capacity three");
        resource.getCapacities().add(capacity3);

        repository.save(resource);

    }
}