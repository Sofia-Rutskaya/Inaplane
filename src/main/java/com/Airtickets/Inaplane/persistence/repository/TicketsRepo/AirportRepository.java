package com.Airtickets.Inaplane.persistence.repository.TicketsRepo;

import com.Airtickets.Inaplane.persistence.entity.Tickets.Airport;
import com.Airtickets.Inaplane.persistence.repository.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends IBaseRepository<Airport> {
}
