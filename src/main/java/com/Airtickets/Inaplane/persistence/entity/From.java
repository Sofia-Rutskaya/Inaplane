package com.Airtickets.Inaplane.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "ticketsfrom")
public @Data class From extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "countryFrom")
    public String countryFrom;

    @Column(name = "cityFrom")
    public String cityFrom;

    @OneToMany(mappedBy = "idTicketsFrom",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    public List<TimeTicket> times = new ArrayList<TimeTicket>();

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Tickets ticket;


}
