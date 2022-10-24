package com.Airtickets.Inaplane.persistence.repository.TicketsRepo;


import com.Airtickets.Inaplane.persistence.entity.Tickets.Plane;
import com.Airtickets.Inaplane.persistence.repository.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends IBaseRepository<Plane> {
}
