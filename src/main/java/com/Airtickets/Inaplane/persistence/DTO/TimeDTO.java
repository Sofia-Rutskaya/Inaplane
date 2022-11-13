package com.Airtickets.Inaplane.persistence.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeDTO extends BaseDTO {
    private Long TicketId;
    private Long Id;
    private String Time;
    private String Date;

    public TimeDTO(Long ticketId, Long id, String time, String date) {
        setTime(time);
        setDate(date);
        setId(id);
        setTicketId(ticketId);

    }
}
