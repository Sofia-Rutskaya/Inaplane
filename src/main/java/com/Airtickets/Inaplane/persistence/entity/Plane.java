package com.Airtickets.Inaplane.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "plane")
public class Plane extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "planeName")
    public String planeName;

    @Column(name = "places")
    public int places;

    @Column(name = "freePlaces")
    public int freePlaces;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Tickets ticket;
}
