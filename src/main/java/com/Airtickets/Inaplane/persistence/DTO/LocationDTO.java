package com.Airtickets.Inaplane.persistence.DTO;

import lombok.Data;

@Data
public class LocationDTO {
    private Long id;
    private String country;
    private String city;
    private String airportName;
}
