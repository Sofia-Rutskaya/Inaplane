package com.Airtickets.Inaplane.persistence.entity.Tickets;

import com.Airtickets.Inaplane.persistence.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "location")
@Data
public class LocationAirport extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @OneToOne(mappedBy = "locationAirport", cascade = CascadeType.ALL)
    private Airport airport;

}
