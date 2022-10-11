package com.Airtickets.Inaplane.persistence.entity.Tickets;

import com.Airtickets.Inaplane.persistence.entity.BaseEntity;
import com.Airtickets.Inaplane.persistence.types.AgeTicket;
import com.Airtickets.Inaplane.persistence.types.Currency;
import com.Airtickets.Inaplane.persistence.types.TicketTypeClass;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users_ticket")
public class UsersTicket extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "place_number")
    public int placeNumber;

    @Enumerated(EnumType.STRING)
    public TicketTypeClass typeClass;

    @Enumerated(EnumType.STRING)
    public AgeTicket ageTicket;

    @Column(name = "price")
    public double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency")
    public Currency currency;

    @Column(name = "active")
    public boolean active;

    @Column(name = "ticket_id")
    public Long ticket;

    @OneToOne
    @JoinColumn(name = "date_ticket_id")
    private TimeTicket times;
}
