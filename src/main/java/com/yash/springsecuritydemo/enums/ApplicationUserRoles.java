package com.yash.springsecuritydemo.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.yash.springsecuritydemo.enums.ApplicationUserPermissions.*;

public enum ApplicationUserRoles {

    STUDENT(new HashSet<>()),
    ADMIN(new HashSet<>(Arrays.asList(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE))),
    ADMINTRAINEE(new HashSet<>(Arrays.asList(COURSE_READ, STUDENT_READ)));

    private final Set<ApplicationUserPermissions> applicationUserPermissions;

    ApplicationUserRoles(Set<ApplicationUserPermissions> applicationUserPermissions) {
        this.applicationUserPermissions = applicationUserPermissions;
    }

    public Set<ApplicationUserPermissions> getApplicationUserPermissions() {
        return applicationUserPermissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities(){

        Set<SimpleGrantedAuthority> grantedAuthorities = getApplicationUserPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());

        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" +  this.name()));

        return grantedAuthorities;


    }
}
