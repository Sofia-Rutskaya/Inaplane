package com.Airtickets.Inaplane.persistence.entity.Tickets;

import com.Airtickets.Inaplane.persistence.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "airport")
@Getter
@Setter
public class Airport extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    public String airportName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private LocationAirport locationAirport;

    @OneToOne(mappedBy = "arrivalAirport", cascade = CascadeType.ALL)
    private Tickets arrival;

    @OneToOne(mappedBy = "departureAirport", cascade = CascadeType.ALL)
    private Tickets departure;
}
