package com.Airtickets.Inaplane.persistence.entity.Tickets;

import com.Airtickets.Inaplane.persistence.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "country_to")
    public String countryTo;

    @Column(name = "city_to")
    public String cityTo;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    public Tickets ticket;

    public CityTo() {

    }
@JsonIgnore
    public Tickets getTicket() {
        return ticket;
    }
}
