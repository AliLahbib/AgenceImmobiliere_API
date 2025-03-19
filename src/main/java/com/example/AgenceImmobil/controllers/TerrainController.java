package com.example.AgenceImmobil.controllers;

import com.example.AgenceImmobil.entities.Terrain;
import com.example.AgenceImmobil.services.TerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/terrains")
@CrossOrigin(origins = "*")
public class TerrainController {

    @Autowired
    private TerrainService terrainService;

    @GetMapping
    public List<Terrain> getAllTerrains() {
        return terrainService.getAllTerrains();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Terrain> getTerrainById(@PathVariable Long id) {
        return terrainService.getTerrainById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Terrain createTerrain(@RequestBody Terrain terrain) {
        return terrainService.saveTerrain(terrain);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Terrain> updateTerrain(@PathVariable Long id, @RequestBody Terrain terrain) {
        return terrainService.getTerrainById(id)
                .map(existingTerrain -> {
                    terrain.setId(id);
                    return ResponseEntity.ok(terrainService.saveTerrain(terrain));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTerrain(@PathVariable Long id) {
        if (terrainService.getTerrainById(id).isPresent()) {
            terrainService.deleteTerrain(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search/usage/{usage}")
    public List<Terrain> findByUsage(@PathVariable String usage) {
        return terrainService.findByUsage(usage);
    }

    @GetMapping("/search/surface-min/{surface}")
    public List<Terrain> findBySurfaceMinimale(@PathVariable float surface) {
        return terrainService.findBySurfaceMinimale(surface);
    }

    @GetMapping("/search/surface-max/{surface}")
    public List<Terrain> findBySurfaceMaximale(@PathVariable float surface) {
        return terrainService.findBySurfaceMaximale(surface);
    }
} 