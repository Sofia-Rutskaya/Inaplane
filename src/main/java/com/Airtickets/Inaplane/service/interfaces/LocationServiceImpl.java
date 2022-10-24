package com.Airtickets.Inaplane.service.interfaces;

import com.Airtickets.Inaplane.persistence.entity.Tickets.LocationAirport;
import com.Airtickets.Inaplane.persistence.repository.TicketsRepo.LocationRepository;
import com.Airtickets.Inaplane.service.LocationService;

import java.util.List;

public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public LocationAirport getById(Long id) {
        return locationRepository.findById(id).get();
    }

    @Override
    public List<LocationAirport> getAll() {
        return locationRepository.findAll();
    }

    @Override
    public void create(LocationAirport ticket) {
        locationRepository.save(ticket);
    }

    @Override
    public void deleteById(Long id) {
        locationRepository.deleteById(id);
    }
}
