package com.Airtickets.Inaplane.persistence.repository.TicketsRepo;

import com.Airtickets.Inaplane.persistence.entity.Tickets.CityFrom;
import com.Airtickets.Inaplane.persistence.repository.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFromRepository extends IBaseRepository<CityFrom> {
   /* @Query("select CityFrom.times from CityFrom as f inner join f.times where
   TimeTicket.idTicketsFrom.id = ?1")
    TimeTicket getTimeById(Long id);
    @Query("select CityFrom.times from CityFrom as f inner  join f.times")
    List<TimeTicket> getTime();*/
}
