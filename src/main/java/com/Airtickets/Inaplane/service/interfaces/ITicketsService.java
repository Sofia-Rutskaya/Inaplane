package com.Airtickets.Inaplane.service.interfaces;
import com.Airtickets.Inaplane.persistence.entity.*;
import com.Airtickets.Inaplane.persistence.entity.Tickets;

import java.util.List;

public interface ITicketsService {
      List<Tickets> getAllTickets();

    void create(Tickets tickets);
    void update(Tickets tickets);
    Tickets getById(Long id);
    void delete(Long id);
}
