package com.example.WetPlant.plants;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "plant")
public class Plant  {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @PrePersist
    protected void onCreate() {
        if (Objects.isNull(this.id)) {
            this.id = UUID.randomUUID();
        }
    }

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "watered", nullable = false)
    private Boolean watered;

    @Column(name = "fertilized", nullable = true)
    private Boolean fertilized;

    @Column(name = "message", nullable = true)
    private String message;


    public Plant(UUID id, LocalDate date, Boolean watered, Boolean fertilized, String message) {
        this.id = id;
        this.date = date;
        this.watered = watered;
        this.fertilized = fertilized;
        this.message = message;
    }

    public Plant() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Boolean getWatered() {
        return watered;
    }

    public void setWatered(Boolean watered) {
        this.watered = watered;
    }

    public Boolean getFertilized() {
        return fertilized;
    }

    public void setFertilized(Boolean fertilized) {
        this.fertilized = fertilized;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

