package com.example.AgenceImmobil.controllers;

import com.example.AgenceImmobil.entities.Type;
import com.example.AgenceImmobil.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/types")
@CrossOrigin(origins = "*")
public class TypeController {

    @Autowired
    private TypeService typeService;

    // Récupérer tous les types
    @GetMapping
    public List<Type> getAllTypes() {
        return typeService.getAllTypes();
    }

    // Récupérer un type par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Type> getTypeById(@PathVariable Long id) {
        return typeService.getTypeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Créer un nouveau type
    @PostMapping
    public Type createType(@RequestBody Type type) {
        return typeService.saveType(type);
    }

    // Mettre à jour un type
    @PutMapping("/{id}")
    public ResponseEntity<Type> updateType(@PathVariable Long id, @RequestBody Type type) {
        return typeService.getTypeById(id)
                .map(existingType -> {
                    type.setId(id);
                    return ResponseEntity.ok(typeService.saveType(type));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Supprimer un type
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteType(@PathVariable Long id) {
        if (typeService.getTypeById(id).isPresent()) {
            typeService.deleteType(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Rechercher par type spécifique (Bâtiment ou Terrain)
    @GetMapping("/search/{type}")
    public List<Type> findByType(@PathVariable String type) {
        return typeService.findByType(type);
    }

    // Compter le nombre total de types
    @GetMapping("/count")
    public long countTypes() {
        return typeService.getAllTypes().size();
    }
} 