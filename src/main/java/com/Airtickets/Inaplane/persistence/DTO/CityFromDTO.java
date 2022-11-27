package com.Airtickets.Inaplane.persistence.DTO;


import com.Airtickets.Inaplane.persistence.entity.Tickets.CityFrom;

public class CityFromDTO extends BaseDTO {
    public Long id;
    public String countryFrom;
    public String cityFrom;

    public CityFromDTO() {
    }

    public CityFromDTO(Long id, String countryFrom, String cityFrom) {
        this.id = id;
        this.countryFrom = countryFrom;
        this.cityFrom = cityFrom;
    }

    public CityFromDTO(CityFrom cityFrom) {
        this.id = cityFrom.id;
        this.countryFrom = cityFrom.countryFrom;
        this.cityFrom = cityFrom.cityFrom;
    }
}
