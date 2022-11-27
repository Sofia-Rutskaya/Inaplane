package com.Airtickets.Inaplane.persistence.DTO;

import com.Airtickets.Inaplane.persistence.entity.Tickets.CityTo;

public class CityToDTO extends BaseDTO{

    public Long id;

    public String country_to;

    public String city_to;

    public CityToDTO(Long id, String country_to, String city_to) {
        this.id = id;
        this.country_to = country_to;
        this.city_to = city_to;
    }

    public CityToDTO(CityToDTO city) {
        this.id = city.id;
        this.country_to = city.country_to;
        this.city_to = city.city_to;
    }

    public CityToDTO(CityTo city) {
        this.id = city.id;
        this.country_to = city.countryTo;
        this.city_to = city.cityTo;
    }
}
