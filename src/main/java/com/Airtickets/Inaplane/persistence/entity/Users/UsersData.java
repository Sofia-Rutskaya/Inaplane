package com.Airtickets.Inaplane.persistence.entity.Users;

import com.Airtickets.Inaplane.persistence.entity.BaseEntity;
import com.Airtickets.Inaplane.persistence.entity.Tickets.UsersTicket;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users_data")
public class UsersData extends BaseEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany
    @JoinColumn(name = "user_ticket_id")
    private List<UsersTicket> usersTicket;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "registered_user_id")
    public RegisteredUser registeredUsers;
}
