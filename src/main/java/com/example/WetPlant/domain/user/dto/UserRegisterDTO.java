package com.example.WetPlant.domain.user.dto;

import com.example.WetPlant.core.generic.ExtendedDTO;
import com.example.WetPlant.domain.role.dto.RoleDTO;
import javax.validation.constraints.Email;
import java.util.Set;
import java.util.UUID;

public class UserRegisterDTO extends ExtendedDTO {

    private String firstName;

    private String lastName;

    private int age;

    private Double height;

    @Email
    private String email;

    private String password;

    private Set<RoleDTO> roles;

    public UserRegisterDTO(Double height) {
        this.height = height;
    }

    public UserRegisterDTO(UUID id, String firstName, String lastName, int age, Double height, String email, String password, Set<RoleDTO> roles) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Set<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDTO> roles) {
        this.roles = roles;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
