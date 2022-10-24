package com.Airtickets.Inaplane.service;

import com.Airtickets.Inaplane.persistence.entity.Tickets.LocationAirport;

import java.util.List;

public interface LocationService {
    LocationAirport getById(Long id);
    List<LocationAirport> getAll();
    void create(LocationAirport ticket);
    void deleteById(Long id);
}
