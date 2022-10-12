package com.Airtickets.Inaplane.persistence.repository.TicketsRepo;
import com.Airtickets.Inaplane.persistence.entity.Tickets.Tickets;
import com.Airtickets.Inaplane.persistence.repository.IBaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ITicketRepository extends IBaseRepository<Tickets> {
}

