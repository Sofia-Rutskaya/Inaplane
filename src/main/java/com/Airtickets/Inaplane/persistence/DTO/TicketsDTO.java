package com.Airtickets.Inaplane.persistence.DTO;
import com.Airtickets.Inaplane.persistence.entity.Tickets.CityFrom;
import com.Airtickets.Inaplane.persistence.entity.Tickets.Tickets;
import com.Airtickets.Inaplane.persistence.entity.Tickets.TimeTicket;
import com.Airtickets.Inaplane.persistence.types.Currency;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public @Data class TicketsDTO extends BaseDTO{
    public Long id;
    public Time time_in;
    public double price;
    public Currency currency;

    public String country_to;

    public String city_to;

    public String countryFrom;
    public String cityFrom;
    public List<String> dateFrom ;
    public String dateBookingTicket ;
    public String timeBookingTicket ;
    public List<String> timeFrom;

    public TicketsDTO(){
        
    }

    public TicketsDTO(Tickets tickets) {
        if(tickets == null)
            return;
        this.id = tickets.getId();
        this.time_in = tickets.getTimeIn();
        this.price = tickets.getPrice();
        this.currency = tickets.getCurrency();
        this.city_to = tickets.getCityTo().cityTo;
        this.cityFrom = tickets.getFrom().cityFrom;
        this.countryFrom = tickets.getFrom().countryFrom;
        this.country_to = tickets.getCityTo().countryTo;
        this.timeFrom = new ArrayList<>();
        this.dateFrom = new ArrayList<>();
        for (TimeTicket date:
             tickets.getFrom().getTimes()) {
            this.dateFrom.add(date.getDateFrom().toString());
            this.timeFrom.add(date.getTimeFrom().toString());
        }
    }



    @Override
    public String toString() {
        return "TicketsDTO{" +
                "id=" + id +
                ", time_in=" + time_in +
                ", price=" + price +
                ", currency=" + currency +
                '}';
    }
}
