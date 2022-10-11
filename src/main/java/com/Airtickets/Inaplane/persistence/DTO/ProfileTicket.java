package com.Airtickets.Inaplane.persistence.DTO;

import com.Airtickets.Inaplane.persistence.entity.Tickets.Tickets;
import com.Airtickets.Inaplane.persistence.entity.Tickets.TimeTicket;
import com.Airtickets.Inaplane.persistence.entity.Tickets.UsersTicket;
import com.Airtickets.Inaplane.persistence.types.AgeTicket;
import com.Airtickets.Inaplane.persistence.types.Currency;
import com.Airtickets.Inaplane.persistence.types.TicketTypeClass;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class ProfileTicket extends BaseDTO{
    public Long id;
    public Time time_in;
    public double price;
    public Currency currency;

    public String country_to;

    public String city_to;

    public String countryFrom;
    public String cityFrom;
    public int placeNumber;
    public TicketTypeClass typeClass;
    public double finalPrice;
    public AgeTicket ageTicket;
    public LocalDate dateBookingTicket;
    public LocalTime timeBookingTicket;

    public ProfileTicket(UsersTicket usersTicket, Tickets tickets) {
        this.setId(usersTicket.getId());
        this.setTime_in(tickets.timeIn);
        this.price = usersTicket.price;
        this.currency = usersTicket.currency;
        this.country_to = tickets.getCityTo().countryTo;
        this.city_to = tickets.getCityTo().cityTo;
        this.countryFrom = tickets.getFrom().countryFrom;
        this.cityFrom = tickets.getFrom().cityFrom;
        this.placeNumber = usersTicket.placeNumber;
        this.typeClass = usersTicket.typeClass;
        this.finalPrice = usersTicket.price;
        this.ageTicket = usersTicket.ageTicket;
        this.dateBookingTicket = usersTicket.getTimes().dateFrom;
        this.timeBookingTicket = usersTicket.getTimes().timeFrom;
    }


}
