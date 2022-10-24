package com.Airtickets.Inaplane.persistence.entity.Tickets;

import com.Airtickets.Inaplane.persistence.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "plane")
public class Plane extends BaseEntity {
    public Plane(Long id, String planeName, int businessFreePlaces, int firstFreePlaces, int economyFreePlaces, int allCountPlaces) {
        this.id = id;
        this.planeName = planeName;
        this.businessFreePlaces = businessFreePlaces;
        this.firstFreePlaces = firstFreePlaces;
        this.economyFreePlaces = economyFreePlaces;
        this.allCountPlaces = allCountPlaces;
    }

    @JsonIgnore
    public Tickets getTicket() {
        return ticket;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "plane_name")
    private String planeName;


    @Column(name = "business_free_places")
    private int businessFreePlaces;

    @Column(name = "first_free_places")
    private int firstFreePlaces;

    @Column(name = "economy_free_places")
    private int economyFreePlaces;

    @Column(name = "free_places")
    private int allCountPlaces;

    @OneToOne(mappedBy = "plane", cascade = CascadeType.ALL)
    private Tickets ticket;

    public Plane() {

    }
}
