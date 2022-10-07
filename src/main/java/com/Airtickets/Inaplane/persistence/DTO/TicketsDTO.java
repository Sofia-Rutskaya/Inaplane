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
    public List<String> timeFrom;

    public TicketsDTO(Long id, Time time_in, double price,
                      Currency currency, String country_to,
                      String city_to, String countryFrom,
                      String cityFrom, List<String> dateFrom,
                      List<String> timeFrom) {
        this.id = id;
        this.time_in = time_in;
        this.price = price;
        this.currency = currency;
        this.country_to = country_to;
        this.city_to = city_to;
        this.countryFrom = countryFrom;
        this.cityFrom = cityFrom;
        this.dateFrom = dateFrom;
        this.timeFrom = timeFrom;
    }

    public TicketsDTO(){
        
    }

    public TicketsDTO(Tickets tickets) {
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
