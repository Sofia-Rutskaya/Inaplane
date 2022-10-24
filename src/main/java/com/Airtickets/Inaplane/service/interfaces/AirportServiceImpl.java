package com.Airtickets.Inaplane.service.interfaces;

import com.Airtickets.Inaplane.persistence.entity.Tickets.Airport;
import com.Airtickets.Inaplane.persistence.repository.TicketsRepo.AirportRepository;
import com.Airtickets.Inaplane.service.AirportService;

import java.util.List;

public class AirportServiceImpl implements AirportService {
    public final AirportRepository airportRepository;

    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public Airport getById(Long id) {
        return airportRepository.findById(id).get();
    }

    @Override
    public List<Airport> getAll() {
        return airportRepository.findAll();
    }

    @Override
    public void create(Airport ticket) {
        airportRepository.save(ticket);
    }

    @Override
    public void deleteById(Long id) {
        airportRepository.deleteById(id);
    }
}
