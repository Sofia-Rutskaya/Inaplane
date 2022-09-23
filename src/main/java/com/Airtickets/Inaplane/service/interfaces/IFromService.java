package com.Airtickets.Inaplane.service.interfaces;

import com.Airtickets.Inaplane.persistence.entity.CityFrom;
import com.Airtickets.Inaplane.persistence.entity.TimeTicket;

import java.util.List;

public interface IFromService {
    List<CityFrom> getAllItem();

    void create(CityFrom from);
    CityFrom getById(Long id);
    void delete(Long id);

    TimeTicket getTimeById(Long id);
    List<TimeTicket> getTime();
}
