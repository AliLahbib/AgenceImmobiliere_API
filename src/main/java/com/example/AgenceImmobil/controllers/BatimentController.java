package com.example.AgenceImmobil.controllers;

import com.example.AgenceImmobil.entities.Batiment;
import com.example.AgenceImmobil.services.BatimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/batiments")
@CrossOrigin(origins = "*")
public class BatimentController {

    @Autowired
    private BatimentService batimentService;

    @GetMapping
    public List<Batiment> getAllBatiments() {
        return batimentService.getAllBatiments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Batiment> getBatimentById(@PathVariable Long id) {
        return batimentService.getBatimentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Batiment createBatiment(@RequestBody Batiment batiment) {
        return batimentService.saveBatiment(batiment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Batiment> updateBatiment(@PathVariable Long id, @RequestBody Batiment batiment) {
        Batiment updatedBatiment = batimentService.updateBatiment(id, batiment);
        return updatedBatiment != null ? 
            ResponseEntity.ok(updatedBatiment) : 
            ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBatiment(@PathVariable Long id) {
        if (batimentService.existsById(id)) {
            batimentService.deleteBatiment(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search/etages/{nombreMinEtages}")
    public List<Batiment> findByNombreMinEtages(@PathVariable int nombreMinEtages) {
        return batimentService.findByNombreMinEtages(nombreMinEtages);
    }

    @GetMapping("/search/surface/{surfaceMinimale}")
    public List<Batiment> findBySurfaceMinimale(@PathVariable float surfaceMinimale) {
        return batimentService.findBySurfaceMinimale(surfaceMinimale);
    }

    @GetMapping("/search/annee/{anneeMin}")
    public List<Batiment> findByAnneeMinConstruction(@PathVariable int anneeMin) {
        return batimentService.findByAnneeMinConstruction(anneeMin);
    }

    @GetMapping("/search/periode")
    public List<Batiment> findByPeriodeConstruction(
            @RequestParam int anneeDebut, 
            @RequestParam int anneeFin) {
        return batimentService.findByPeriodeConstruction(anneeDebut, anneeFin);
    }
} 