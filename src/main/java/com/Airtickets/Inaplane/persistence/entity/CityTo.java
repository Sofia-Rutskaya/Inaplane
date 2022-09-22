package com.Airtickets.Inaplane.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ticketsto")
public class CityTo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "countryTo")
    public String countryTo;

    @Column(name = "cityTo")
    public String cityTo;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Tickets ticket;
}
