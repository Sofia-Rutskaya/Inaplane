package com.Airtickets.Inaplane.persistence.DTO;
import com.Airtickets.Inaplane.persistence.entity.Tickets.Tickets;
import com.Airtickets.Inaplane.persistence.types.Currency;
import lombok.Data;

import java.sql.Time;

public @Data class TicketsDTO extends BaseDTO{
    public Long id;
    public Time time_in;
    public double price;
    public Currency currency;

    public TicketsDTO(Long id, Time time_in, double price, Currency currency) {
        this.id = id;
        this.time_in = time_in;
        this.price = price;
        this.currency = currency;
    }

    public TicketsDTO(){
        
    }

    public TicketsDTO(Tickets tickets) {
        this.id = tickets.getId();
        this.time_in = tickets.getTimeIn();
        this.price = tickets.getPrice();
        this.currency = tickets.getCurrency();
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
