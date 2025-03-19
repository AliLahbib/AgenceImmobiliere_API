package com.example.AgenceImmobil.repositories;

import com.example.AgenceImmobil.entities.Batiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatimentRepository extends JpaRepository<Batiment, Long> {
    List<Batiment> findByNombreDEtagesGreaterThanEqual(int nombreMinEtages);
    List<Batiment> findBySurfaceTotaleGreaterThanEqual(float surfaceMinimale);
    List<Batiment> findByAnneeDeConstructionGreaterThanEqual(int anneeMin);
    List<Batiment> findByAnneeDeConstructionBetween(int anneeDebut, int anneeFin);
} 