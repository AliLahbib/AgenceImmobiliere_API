package com.example.AgenceImmobil.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity

public class Terrain extends Type {

    @Column(nullable = false)
    private float surfaceTotale;


    @Column(name = "`usage`", nullable = true)
    private String usage; // Résidentiel, commercial, etc.

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Terrain() {
        super();
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public Terrain(float surfaceTotale, String usage) {
        this();
        this.surfaceTotale = surfaceTotale;
        this.usage = usage;
    }

    public float getSurfaceTotale() {
        return surfaceTotale;
    }

    public void setSurfaceTotale(float surfaceTotale) {
        this.surfaceTotale = surfaceTotale;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}