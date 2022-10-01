package com.Airtickets.Inaplane.persistence.DTO;


import javax.persistence.Column;

public class PlaneDTO extends BaseDTO{
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
}
