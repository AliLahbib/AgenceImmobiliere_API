package com.example.AgenceImmobil.entities;

import jakarta.persistence.*;

import org.jetbrains.annotations.*;


import java.util.Date;

@Entity

public class Batiment extends Type {
    @NotNull
    @Column(nullable = false)
    private int nombreDEtages;

    @NotNull
    @Column(nullable = false)
    private float surfaceTotale;

    @NotNull

    @Column(nullable = false)
    private int anneeDeConstruction;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Batiment() {
        super();
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public Batiment(int nombreDEtages, float surfaceTotale, int anneeDeConstruction) {
        this();
        this.nombreDEtages = nombreDEtages;
        this.surfaceTotale = surfaceTotale;
        this.anneeDeConstruction = anneeDeConstruction;
    }

    public int getNombreDEtages() {
        return nombreDEtages;
    }

    public void setNombreDEtages(int nombreDEtages) {
        this.nombreDEtages = nombreDEtages;
    }

    public float getSurfaceTotale() {
        return surfaceTotale;
    }

    public void setSurfaceTotale(float surfaceTotale) {
        this.surfaceTotale = surfaceTotale;
    }

    public int getAnneeDeConstruction() {
        return anneeDeConstruction;
    }

    public void setAnneeDeConstruction(int anneeDeConstruction) {
        this.anneeDeConstruction = anneeDeConstruction;
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
