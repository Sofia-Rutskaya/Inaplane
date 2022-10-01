package com.Airtickets.Inaplane.service.interfaces;

import com.Airtickets.Inaplane.persistence.entity.Tickets.CityTo;

import java.util.List;

public interface IToService {
    List<CityTo> getAllItem();

    void create(CityTo cityTo);
    CityTo getById(Long id);
    void delete(Long id);
}
