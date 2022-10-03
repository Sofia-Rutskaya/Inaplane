package com.Airtickets.Inaplane.service;


import com.Airtickets.Inaplane.persistence.entity.Tickets.CityTo;
import com.Airtickets.Inaplane.persistence.repository.TicketsRepo.IToRepository;
import com.Airtickets.Inaplane.service.interfaces.IToService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToService implements IToService {

    private IToRepository _toRepository;

    public ToService(IToRepository toRepository) {
        _toRepository = toRepository;
    }

    @Override
    public List<CityTo> getAllItem() {
        return _toRepository.findAll();
    }

    @Override
    public void create(CityTo cityTo) {
        _toRepository.save(cityTo);
    }

    @Override
    public CityTo getById(Long id) {
        return _toRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        _toRepository.deleteById(id);
    }
}
