package com.Airtickets.Inaplane.persistence.entity.Users;

import com.Airtickets.Inaplane.persistence.entity.BaseEntity;
import com.Airtickets.Inaplane.persistence.types.Roles;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "registered_users")
public class RegisteredUser extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "email",nullable = false, unique = true)
    private String email;

    @OneToOne(mappedBy = "registeredUsers", cascade = CascadeType.ALL)
    private UsersData usersData;

    @Column(name = "password", nullable = false)
    public String password;
    @Column(name = "enabled")
    private Boolean enabled;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_type", nullable = false)
    private Roles roles;

    public RegisteredUser() {
        this.enabled = true;
    }

}
