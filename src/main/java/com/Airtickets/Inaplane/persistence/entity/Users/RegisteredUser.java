package com.Airtickets.Inaplane.persistence.entity.Users;

import com.Airtickets.Inaplane.persistence.entity.BaseEntity;
import com.Airtickets.Inaplane.persistence.entity.Tickets.UsersTicket;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "registered_users")
public class RegisteredUser extends BaseEntity {
    public RegisteredUser(String fullName, String email, String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.enabled = true;
    }
    public RegisteredUser(RegisteredUser user) {
        this.fullName = user.getFullName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.enabled = true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "full_name", nullable = false)
    public String fullName;

    @Column(name = "email",nullable = false, unique = true)
    public String email;

    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "role")
    public String role;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_ticket_id")
    public List<UsersTicket> usersTicket;

    public RegisteredUser() {
        this.enabled = true;
    }

}
