package com.Airtickets.Inaplane.service.interfaces;

import com.Airtickets.Inaplane.persistence.entity.From;

import java.util.List;

public interface IFromService {
    List<From> getAllItem();

    void create(From from);
    From getById(Long id);
    void delete(Long id);
}
