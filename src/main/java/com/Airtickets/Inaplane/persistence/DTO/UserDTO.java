package com.Airtickets.Inaplane.persistence.DTO;

import com.Airtickets.Inaplane.persistence.entity.Users.RegisteredUser;
import com.Airtickets.Inaplane.persistence.types.Currency;
import com.Airtickets.Inaplane.persistence.types.TicketTypeClass;

public class UserDTO {
    public Long userId;

    public String fullName;
    public int placeNumber;
    public String email;
    public TicketTypeClass typeClass;
    public double finalPrice;
    public String role;

    public UserDTO(Long userId, String fullName,
                   int placeNumber, String email,
                   TicketTypeClass typeClass,
                   double finalPrice, String role) {
        this.userId = userId;
        this.fullName = fullName;
        this.placeNumber = placeNumber;
        this.email = email;
        this.typeClass = typeClass;
        this.finalPrice = finalPrice;
        this.role = role;
    }

    public UserDTO(RegisteredUser user) {
        this.fullName = user.getFullName();
        this.email = user.getEmail();
        this.userId = user.getId();
        this.role = user.getRole();
    }
}
