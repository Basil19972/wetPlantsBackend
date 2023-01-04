package com.example.WetPlant.domain.plant;

import com.example.WetPlant.core.generic.ExtendedEntity;
import com.example.WetPlant.core.generic.ExtendedEntityAudit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;


@Entity
@Table(name = "plant")
public class Plant extends ExtendedEntityAudit {

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "watered", nullable = false)
    private Boolean watered;

    @Column(name = "fertilized", nullable = true)
    private Boolean fertilized;

    @Column(name = "message", nullable = true)
    private String message;

    public Plant(LocalDate date, Boolean watered, Boolean fertilized, String message) {
        this.date = date;
        this.watered = watered;
        this.fertilized = fertilized;
        this.message = message;
    }

    public Plant() {
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

