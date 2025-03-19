package com.example.AgenceImmobil.repositories;

import com.example.AgenceImmobil.entities.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TerrainRepository extends JpaRepository<Terrain, Long> {
    List<Terrain> findByUsage(String usage);
    List<Terrain> findBySurfaceTotaleGreaterThanEqual(float surfaceMinimale);
    List<Terrain> findBySurfaceTotaleLessThanEqual(float surfaceMaximale);
} 