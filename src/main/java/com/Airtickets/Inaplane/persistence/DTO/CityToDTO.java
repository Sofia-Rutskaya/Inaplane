package com.Airtickets.Inaplane.persistence.DTO;

public class CityToDTO extends BaseDTO{

    public Long id;

    public String country_to;

    public String city_to;

    public CityToDTO(Long id, String country_to, String city_to) {
        this.id = id;
        this.country_to = country_to;
        this.city_to = city_to;
    }
}
