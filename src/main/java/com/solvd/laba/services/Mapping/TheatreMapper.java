package com.solvd.laba.services.Mapping;

import com.solvd.laba.models.Theatre;

import java.util.List;

public interface TheatreMapper {
    Theatre findById(Integer id);
    List<Theatre> findAll();
    void insert(Theatre theatre);
    void update(Theatre theatre);
    void delete(Theatre theatre);
    List<Theatre> findByLocation(String location);
}