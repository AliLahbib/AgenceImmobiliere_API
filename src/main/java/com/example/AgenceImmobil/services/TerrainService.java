package com.example.AgenceImmobil.services;

import com.example.AgenceImmobil.entities.Terrain;
import com.example.AgenceImmobil.repositories.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TerrainService {
    
    @Autowired
    private TerrainRepository terrainRepository;

    public List<Terrain> getAllTerrains() {
        return terrainRepository.findAll();
    }

    public Optional<Terrain> getTerrainById(Long id) {
        return terrainRepository.findById(id);
    }

    public Terrain saveTerrain(Terrain terrain) {
        System.out.println("✅ add terrain");

        return terrainRepository.save(terrain);
    }

    public void deleteTerrain(Long id) {
        terrainRepository.deleteById(id);
    }

    // Méthodes spécifiques
    public List<Terrain> findByUsage(String usage) {
        return terrainRepository.findByUsage(usage);
    }

    public List<Terrain> findBySurfaceMinimale(float surfaceMinimale) {
        return terrainRepository.findBySurfaceTotaleGreaterThanEqual(surfaceMinimale);
    }

    public List<Terrain> findBySurfaceMaximale(float surfaceMaximale) {
        return terrainRepository.findBySurfaceTotaleLessThanEqual(surfaceMaximale);
    }
} 