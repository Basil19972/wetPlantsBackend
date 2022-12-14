package com.example.WetPlant.domain.user.dto;

import com.example.WetPlant.core.generic.ExtendedDTO;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;


public class UserRegisterDTO extends ExtendedDTO {

    @Size(max = 7)
    private String username;

    @Email
    private String email;

    private String password;

    public UserRegisterDTO(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
