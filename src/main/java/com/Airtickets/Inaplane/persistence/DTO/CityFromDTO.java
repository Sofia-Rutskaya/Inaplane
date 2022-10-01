package com.Airtickets.Inaplane.persistence.DTO;


public class CityFromDTO extends BaseDTO {
    public Long id;
    public String countryFrom;
    public String cityFrom;

    public CityFromDTO(Long id, String countryFrom, String cityFrom) {
        this.id = id;
        this.countryFrom = countryFrom;
        this.cityFrom = cityFrom;
    }
}
