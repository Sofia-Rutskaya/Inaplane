package com.Airtickets.Inaplane.persistence.entity.Users;

import com.Airtickets.Inaplane.persistence.entity.BaseEntity;
import com.Airtickets.Inaplane.persistence.types.Roles;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "registered_users")
public class RegisteredUser extends BaseEntity {
    public RegisteredUser(String fullName, String email, String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.enabled = true;
        this.roles = Roles.REGISTERED_USER;
    }
    public RegisteredUser(RegisteredUser user) {
        this.fullName = user.getFullName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.enabled = true;
        this.roles = Roles.REGISTERED_USER;
    }

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
    @Column(name = "role_type")
    private Roles roles;

    public RegisteredUser() {
        this.enabled = true;
        this.roles = Roles.REGISTERED_USER;
    }

}
