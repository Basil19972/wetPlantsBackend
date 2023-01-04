package com.example.WetPlant.domain.user.dto;

import com.example.WetPlant.core.generic.ExtendedDTO;
import com.example.WetPlant.domain.role.dto.RoleDTO;

import javax.validation.constraints.Email;
import java.util.Set;
import java.util.UUID;

public class UserDTO extends ExtendedDTO {

    private String username;


    @Email
    private String email;

    private Set<RoleDTO> roles;

    public UserDTO() {
    }

    public UserDTO(String username, String email, Set<RoleDTO> roles) {
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDTO> roles) {
        this.roles = roles;
    }
}
