package com.sipra.fesc.Security;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    // private final UserEntidad usuarioEntity;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return "usuarioEntity.getPasswordEncriptada();";
    }

    @Override
    public String getUsername() {
        return "usuarioEntity.getEmail();";
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
        return true;
    }

   

    // public String getNombre() {
    //     return usuarioEntity.getNombre();
    // }

    // public String getApellido() {
    //     return usuarioEntity.getApellido();
    // }

    // public Long getIdRol() {
    //     return usuarioEntity.getEntidadRol().getId();
    // }

    // public Long getIdUser() {
    //     return usuarioEntity.getId();
    // }

}