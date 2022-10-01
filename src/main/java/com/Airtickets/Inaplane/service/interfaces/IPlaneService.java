package com.Airtickets.Inaplane.service.interfaces;

import com.Airtickets.Inaplane.persistence.entity.Tickets.Plane;

import java.util.List;

public interface IPlaneService {
    List<Plane> getAllItem();

    void create(Plane plane);
    Plane getById(Long id);
    void delete(Long id);
}
