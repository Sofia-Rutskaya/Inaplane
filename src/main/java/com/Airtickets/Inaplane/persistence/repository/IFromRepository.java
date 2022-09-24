package com.Airtickets.Inaplane.persistence.repository;

import com.Airtickets.Inaplane.persistence.entity.CityFrom;
import com.Airtickets.Inaplane.persistence.entity.TimeTicket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IFromRepository extends IBaseRepository<CityFrom>{
   /* @Query("select CityFrom.times from CityFrom as f inner join f.times where
   TimeTicket.idTicketsFrom.id = ?1")
    TimeTicket getTimeById(Long id);
    @Query("select CityFrom.times from CityFrom as f inner  join f.times")
    List<TimeTicket> getTime();*/
}
