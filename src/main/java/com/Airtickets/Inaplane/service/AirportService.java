package com.Airtickets.Inaplane.service;

import com.Airtickets.Inaplane.persistence.entity.Tickets.Airport;

import java.util.List;

public interface AirportService {
    Airport getById(Long id);
    List<Airport> getAll();
    void create(Airport ticket);
    void deleteById(Long id);
}
