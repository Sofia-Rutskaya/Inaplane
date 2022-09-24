package com.Airtickets.Inaplane.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;


@Data
@Entity
@Table(name = "tickets")
public class Tickets extends BaseEntity  {
    public Tickets(Long id, Time timeIn) {
        this.id = id;
        this.timeIn = timeIn;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "time_in", nullable = false)
    public Time timeIn;

    @OneToOne(mappedBy = "ticket", cascade = CascadeType.ALL)
    private CityFrom from;

    @OneToOne(mappedBy = "ticket", cascade = CascadeType.ALL)
    private Plane plane;

    @OneToOne(mappedBy = "ticket", cascade = CascadeType.ALL)
    private CityTo cityTo;

    public Tickets() {

    }
}
