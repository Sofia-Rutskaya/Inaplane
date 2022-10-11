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
    public Long id;

    @Column(name = "plane_name")
    public String planeName;


    @Column(name = "business_free_places")
    public int businessFreePlaces;

    @Column(name = "first_free_places")
    public int firstFreePlaces;

    @Column(name = "economy_free_places")
    public int economyFreePlaces;

    @Column(name = "free_places")
    public int allCountPlaces;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    private Tickets ticket;

    public Plane() {

    }
}
