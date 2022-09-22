package com.Airtickets.Inaplane.persistence.entity;

import java.util.Date;
import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import org.springframework.web.bind.annotation.*;


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
    private From from;

    @OneToOne(mappedBy = "ticket", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Plane plane;

    @OneToOne(mappedBy = "ticket", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private CityTo cityTo;
}
