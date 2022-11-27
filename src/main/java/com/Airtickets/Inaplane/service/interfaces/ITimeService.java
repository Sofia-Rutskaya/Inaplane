package com.Airtickets.Inaplane.service.interfaces;

import com.Airtickets.Inaplane.persistence.entity.Tickets.TimeTicket;

import java.util.List;

public interface ITimeService {
    void getTime(Long id);
    List<TimeTicket> getAll();
    void create(TimeTicket ticket);
    void deleteById(Long id);
}
