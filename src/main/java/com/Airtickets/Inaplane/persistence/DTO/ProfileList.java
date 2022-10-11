package com.Airtickets.Inaplane.persistence.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProfileList extends BaseDTO{
    public List<ProfileTicket> ticket;
}
