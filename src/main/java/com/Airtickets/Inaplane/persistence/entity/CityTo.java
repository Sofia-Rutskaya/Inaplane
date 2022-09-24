package com.Airtickets.Inaplane.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ticketsto")
public class CityTo extends BaseEntity {
    public CityTo(Long id, String countryTo, String cityTo) {
        this.id = id;
        this.countryTo = countryTo;
        this.cityTo = cityTo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "country_to", nullable = false)
    public String countryTo;

    @Column(name = "city_to", nullable = false)
    public String cityTo;

    @OneToOne
    @JoinColumn(name = "ticket_id" , nullable = false)
    public Tickets ticket;

    public CityTo() {

    }
}
