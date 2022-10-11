package com.Airtickets.Inaplane.persistence.entity.Tickets;

import com.Airtickets.Inaplane.persistence.entity.BaseEntity;
import com.Airtickets.Inaplane.persistence.types.Currency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;


@Getter
@Setter
@Entity
@Table(name = "tickets")
public class Tickets extends BaseEntity {
    public Tickets(Long id, Time timeIn) {
        this.id = id;
        this.timeIn = timeIn;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "time_in", nullable = false)
    public Time timeIn;

    @Column(name = "price", nullable = false)
    public double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false)
    public Currency currency;


    @OneToOne(mappedBy = "ticket", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private CityFrom from;

    @OneToOne(mappedBy = "ticket", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Plane plane;



    @OneToOne(mappedBy = "ticket",  cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private CityTo cityTo;

    public Tickets() {

    }

}
