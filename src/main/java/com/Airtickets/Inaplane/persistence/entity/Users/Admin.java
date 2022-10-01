package com.Airtickets.Inaplane.persistence.entity.Users;

import com.Airtickets.Inaplane.persistence.types.Roles;

public class Admin extends RegisteredUser {
    public Admin(){
        this.setRoles(Roles.ADMIN);
    }
}
