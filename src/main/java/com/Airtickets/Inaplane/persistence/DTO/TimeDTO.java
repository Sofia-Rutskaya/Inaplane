package com.Airtickets.Inaplane.persistence.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeDTO {
    public String Time;
    public String Date;

    public TimeDTO(String time, String date) {
        Time = time;
        Date = date;
    }
}
