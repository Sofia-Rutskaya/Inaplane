package com.Airtickets.Inaplane.persistence.DTO;

import com.Airtickets.Inaplane.persistence.entity.Tickets.Plane;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class PlaneDTO extends BaseDTO {
    public PlaneDTO() {
    }

    public Long id;

    public String planeName;


    public int businessFreePlaces;

    public int firstFreePlaces;

    public int economyFreePlaces;

    public int allCountPlaces;

    public PlaneDTO(Long id, String planeName, int businessFreePlaces, int firstFreePlaces, int economyFreePlaces, int allCountPlaces) {
        this.id = id;
        this.planeName = planeName;
        this.businessFreePlaces = businessFreePlaces;
        this.firstFreePlaces = firstFreePlaces;
        this.economyFreePlaces = economyFreePlaces;
        this.allCountPlaces = allCountPlaces;
    }

    public PlaneDTO(Plane plane) {
        this.id = plane.id;
        this.planeName = plane.planeName;
        this.businessFreePlaces = plane.businessFreePlaces;
        this.firstFreePlaces = plane.firstFreePlaces;
        this.economyFreePlaces = plane.economyFreePlaces;
        this.allCountPlaces = plane.allCountPlaces;
    }
}
