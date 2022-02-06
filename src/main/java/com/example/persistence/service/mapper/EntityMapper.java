package com.example.persistence.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface EntityMapper <T, D>{

    D toDto(T t);

    T toEntity(D d);

    default List<D> toDto(List<T> t) {
       return t.stream().map(this::toDto).collect(Collectors.toList());
    }

    default List<T> toEntity(List<D> d) {
        return d.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
