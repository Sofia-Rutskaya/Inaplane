package com.Airtickets.Inaplane.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.util.*;

@Entity
@Table(name = "ticketsfrom")
public @Data class CityFrom extends BaseEntity {
    public CityFrom(Long id, String countryFrom, String cityFrom) {
        this.id = id;
        this.countryFrom = countryFrom;
        this.cityFrom = cityFrom;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "country_from", nullable = false)
    public String countryFrom;
    @Column(name = "city_from", nullable = false)
    public String cityFrom;
    @OneToMany
    @JoinColumn(name = "city_from_id", nullable = false)
    private List<TimeTicket> times;
    @OneToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private Tickets ticket;

    public CityFrom() {

    }
}
