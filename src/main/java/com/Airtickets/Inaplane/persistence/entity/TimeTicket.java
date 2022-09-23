package com.Airtickets.Inaplane.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tisketsdate")
public @Data class TimeTicket extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="idTicketsFrom")
    public CityFrom idTicketsFrom;

    @Column(name = "dateFrom")
    public String dateFrom;

    @Column(name = "timeFrom")
    public String timeFrom;
}
