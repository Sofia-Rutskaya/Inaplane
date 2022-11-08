package com.Airtickets.Inaplane.persistence.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeDTO {
    private Long TicketId;
    private Long Id;
    private String Time;
    private String Date;

    public TimeDTO(String time, String date) {
        Time = time;
        Date = date;
    }
}
