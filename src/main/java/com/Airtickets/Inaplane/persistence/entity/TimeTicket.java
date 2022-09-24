package com.Airtickets.Inaplane.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "ticketsdate")
public @Data class TimeTicket extends BaseEntity {

    public TimeTicket() {
    }

    public TimeTicket(Long id, Date dateFrom) {
        this.id = id;
        this.dateFrom = dateFrom;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "date_from", nullable = false)
    public Date dateFrom;
}
