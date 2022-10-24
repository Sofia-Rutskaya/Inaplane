package com.Airtickets.Inaplane.persistence.entity.Tickets;

import com.Airtickets.Inaplane.persistence.entity.BaseEntity;
import com.Airtickets.Inaplane.persistence.types.Currency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "tickets")
public class Tickets extends BaseEntity {
    public Tickets(Long id, LocalTime flightHour) {
        this.id = id;
        this.flightHour = flightHour;
    }

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "arrival_airport_id")
    private Airport arrivalAirport;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "time_id")
    private Schedule time;
    @Column(name = "flight_hour")
    private LocalTime flightHour;

    @Column(name = "price")
    private double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency")
    private Currency currency;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "plane_id")
    private Plane plane;



    public Tickets() {

    }

}
