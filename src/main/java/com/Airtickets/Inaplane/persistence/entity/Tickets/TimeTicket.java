package com.Airtickets.Inaplane.persistence.entity.Tickets;

import com.Airtickets.Inaplane.persistence.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "ticketsdate")
public @Data class TimeTicket extends BaseEntity {

    public TimeTicket() {
    }

    public TimeTicket(Long id, LocalDate dateFrom) {
        this.id = id;
        this.dateFrom = dateFrom;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "date_from")
    public LocalDate dateFrom;
    @Column(name = "time_from")
    public LocalTime timeFrom;
}
