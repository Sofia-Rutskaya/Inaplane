package com.Airtickets.Inaplane.service;

import com.Airtickets.Inaplane.persistence.entity.Tickets.Plane;

import java.util.List;

public interface PlaneService {
    List<Plane> getAllItem();

    void create(Plane plane);
    Plane getById(Long id);
    void delete(Long id);
}
