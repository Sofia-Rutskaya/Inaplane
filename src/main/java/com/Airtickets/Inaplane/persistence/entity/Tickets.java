package com.Airtickets.Inaplane.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;


@Data
@Entity
@Table(name = "tiskets")
public class Tickets extends BaseEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "timeIn")
    public Time timeIn;

    @OneToOne(mappedBy = "ticket", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private CityFrom from;

    @OneToOne(mappedBy = "ticket", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Plane plane;

    @OneToOne(mappedBy = "ticket", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private CityTo cityTo;
}
