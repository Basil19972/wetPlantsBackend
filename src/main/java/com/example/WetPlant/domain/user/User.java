package com.example.WetPlant.domain.user;


import com.example.WetPlant.core.generic.ExtendedEntityAudit;
import com.example.WetPlant.domain.role.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends ExtendedEntityAudit {

    @Column(name = "user_name")
    private String username;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "notLocked")
    private boolean notLocked;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "users_role",
            joinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles = new HashSet<>();


    public User(String username, String email, String password, boolean notLocked, Set<Role> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.notLocked = notLocked;
        this.roles = roles;
    }

    public User() {
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

    public boolean isNotLocked() {
        return notLocked;
    }

    public void setNotLocked(boolean notLocked) {
        this.notLocked = notLocked;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
