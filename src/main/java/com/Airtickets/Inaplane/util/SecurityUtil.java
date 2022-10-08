package com.Airtickets.Inaplane.util;

import com.Airtickets.Inaplane.security.UserDetail;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.concurrent.atomic.AtomicBoolean;

public final class SecurityUtil {

    private SecurityUtil() { }

    public static boolean hasRole(String role) {
        Authentication authentication = SecurityUtil.getAuthentication();
        AtomicBoolean result = new AtomicBoolean(false);
        authentication.getAuthorities().forEach(authority -> result.set(authority.getAuthority().equalsIgnoreCase(role)));
        return result.get();
    }

    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static String getUsername() {
        Authentication authentication = SecurityUtil.getAuthentication();
        UserDetail principal = (UserDetail) authentication.getPrincipal();
        return principal.getUsername();
    }
}

