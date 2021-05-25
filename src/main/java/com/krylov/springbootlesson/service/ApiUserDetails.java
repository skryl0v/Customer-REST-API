package com.krylov.springbootlesson.service;

import com.krylov.springbootlesson.model.ApiUserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ApiUserDetails implements UserDetails {
    private ApiUserEntity apiUser;

    public ApiUserDetails(ApiUserEntity apiUser) {
        this.apiUser = apiUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("USER"));
        return authorities;
    }

    @Override
    public String getPassword() {
        return apiUser.getPassword();
    }

    @Override
    public String getUsername() {
        return apiUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return apiUser.isEnabled();
    }
}