package com.Airtickets.Inaplane.service;

import com.Airtickets.Inaplane.persistence.entity.Tickets.CityFrom;
import com.Airtickets.Inaplane.persistence.entity.Tickets.TimeTicket;
import com.Airtickets.Inaplane.persistence.repository.TicketsRepo.IFromRepository;
import com.Airtickets.Inaplane.service.interfaces.IFromService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FromService implements IFromService {
    private final IFromRepository _fromRepository;

    public FromService(IFromRepository fromRepository) {
        _fromRepository = fromRepository;

    }

    @Override
    public TimeTicket getTimeById(Long id) {
       // return _fromRepository.getTimeById(id);
        return null;
    }

    @Override
    public List<CityFrom> getAllItem() {
        return _fromRepository.findAll();
    }

    @Override
    public void create(CityFrom from) {
        _fromRepository.save(from);
    }

    @Override
    public List<TimeTicket> getTime() {
       // return _fromRepository.getTime();
        return null;
    }

    @Override
    public CityFrom getById(Long id) {
        return _fromRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        _fromRepository.deleteById(id);
    }


}
