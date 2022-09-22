package com.Airtickets.Inaplane.persistence.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "tisketsdate")
public @Data class TimeTicket extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="idTicketsFrom")
    public From idTicketsFrom;

    @Column(name = "dateFrom")
    public String dateFrom;

    @Column(name = "timeFrom")
    public String timeFrom;
}
