package com.Airtickets.Inaplane.persistence.repository;
import com.Airtickets.Inaplane.persistence.entity.Tickets.Tickets;
import org.springframework.stereotype.Repository;

@Repository
public interface ITicketRepository extends IBaseRepository<Tickets> {
}

