package com.Airtickets.Inaplane.service;

import com.Airtickets.Inaplane.persistence.entity.Tickets.TimeTicket;
import com.Airtickets.Inaplane.persistence.repository.TicketsRepo.TimeRepository;
import com.Airtickets.Inaplane.service.interfaces.ITimeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeService implements ITimeService {
    private final TimeRepository timeRepository;

    public TimeService(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    public void getTime(Long id){
        timeRepository.findById(id);
    }

    public List<TimeTicket> getAll(){
        return timeRepository.findAll();
    }

    public void create(TimeTicket ticket){
        timeRepository.save(ticket);
    }
    public void deleteById(Long id){
        timeRepository.deleteById(id);
    }


}
