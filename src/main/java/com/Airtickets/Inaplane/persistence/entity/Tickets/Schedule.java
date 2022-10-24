package com.Airtickets.Inaplane.persistence.entity.Tickets;

import com.Airtickets.Inaplane.persistence.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "schedule")
public @Data class Schedule extends BaseEntity {

    public Schedule() {
    }

    public Schedule(Long id, LocalDate date) {
        this.id = id;
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;



    @Column(name = "date_from")
    private LocalDate date;
    @Column(name = "time_from")
    private LocalTime time;

    @OneToOne(mappedBy = "time", cascade = CascadeType.ALL)
    private Tickets ticket;

}
