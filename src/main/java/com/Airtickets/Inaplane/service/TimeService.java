package com.Airtickets.Inaplane.service;

import com.Airtickets.Inaplane.persistence.entity.Tickets.Schedule;

import java.util.List;

public interface TimeService {
    void getTime(Long id);
    List<Schedule> getAll();
    void create(Schedule ticket);
    void deleteById(Long id);
}
