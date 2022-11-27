package com.Airtickets.Inaplane.persistence.entity.Tickets;

import com.Airtickets.Inaplane.persistence.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
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
    @Column(name = "country_from")
    public String countryFrom;
    @Column(name = "city_from")
    public String cityFrom;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_from_id")
    private List<TimeTicket> times;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    private Tickets ticket;
@JsonIgnore
    public Tickets getTicket() {
        return ticket;
    }

    public CityFrom() {

    }
}
