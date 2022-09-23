package com.Airtickets.Inaplane.persistence.repository;

import com.Airtickets.Inaplane.persistence.entity.CityTo;
import com.Airtickets.Inaplane.persistence.entity.Tickets;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IToRepository extends IBaseRepository<CityTo>{
}
