package com.Airtickets.Inaplane.service.interfaces;

import com.Airtickets.Inaplane.persistence.entity.Tickets.Schedule;
import com.Airtickets.Inaplane.persistence.repository.TicketsRepo.TimeRepository;
import com.Airtickets.Inaplane.service.TimeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeServiceImpl implements TimeService {
    private final TimeRepository timeRepository;

    public TimeServiceImpl(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    public void getTime(Long id){
        timeRepository.findById(id);
    }

    public List<Schedule> getAll(){
        return timeRepository.findAll();
    }

    public void create(Schedule ticket){
        timeRepository.save(ticket);
    }
    public void deleteById(Long id){
        timeRepository.deleteById(id);
    }


}
