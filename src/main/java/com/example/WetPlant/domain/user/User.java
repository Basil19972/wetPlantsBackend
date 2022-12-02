package com.example.WetPlant.domain.user;


import com.example.WetPlant.core.generic.ExtendedEntityAudit;
import com.example.WetPlant.domain.role.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User extends ExtendedEntityAudit {

//HELLO
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "height", nullable = false)
    private Double height;

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



    public User(UUID uuid, String firstName, String lastName, int age, Double height, String email, String password, boolean notLocked, Set<Role> roles) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.email = email;
        this.password = password;
        this.notLocked = notLocked;

        this.roles = roles;
        super.setId(uuid);
    }
    public User( String firstName, String lastName, int age,Double height, String email, String password, boolean notLocked, Set<Role> roles) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.email = email;
        this.password = password;
        this.notLocked = notLocked;

        this.roles = roles;

    }

    public User() {
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

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isNotLocked() {
        return notLocked;
    }

    public void setNotLocked(boolean locked) {
        this.notLocked = locked;
    }
}
