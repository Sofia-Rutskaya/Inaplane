package com.Airtickets.Inaplane.service;
import com.Airtickets.Inaplane.persistence.entity.Tickets.Tickets;

import java.time.LocalDate;
import java.util.List;

public interface TicketsService {
      List<Tickets> getAllTickets();
    void create(Tickets tickets);
    Long getTicket(String cityFrom, String cityTo, LocalDate datatime);
    void update(Tickets tickets);
    Tickets getById(Long id);
    void delete(Long id);
}
