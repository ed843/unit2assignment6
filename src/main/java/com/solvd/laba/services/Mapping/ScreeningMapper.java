package com.solvd.laba.services.Mapping;

import com.solvd.laba.models.Screening;

import java.util.List;

public interface ScreeningMapper {
    Screening findById(Integer id);
    List<Screening> findAll();
    void insert(Screening screening);
    void update(Screening screening);
    void delete(Screening screening);
    List<Screening> findByMovieId(Integer id);
}
