package com.Airtickets.Inaplane.persistence.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "plane")
public class Plane extends BaseEntity{
    public Plane(Long id, String planeName, int places, int freePlaces) {
        this.id = id;
        this.planeName = planeName;
        this.places = places;
        this.freePlaces = freePlaces;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "plane_name", nullable = false)
    public String planeName;

    @Column(name = "places", nullable = false)
    public int places;

    @Column(name = "free_places", nullable = false)
    public int freePlaces;

    @OneToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private Tickets ticket;

    public Plane() {

    }
}
