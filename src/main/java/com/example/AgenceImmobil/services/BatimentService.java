package com.example.AgenceImmobil.services;

import com.example.AgenceImmobil.entities.Batiment;
import com.example.AgenceImmobil.repositories.BatimentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BatimentService {
    
    @Autowired
    private BatimentRepository batimentRepository;

    // Récupérer tous les bâtiments
    public List<Batiment> getAllBatiments() {
        return batimentRepository.findAll();
    }

    // Récupérer un bâtiment par son ID
    public Optional<Batiment> getBatimentById(Long id) {
        return batimentRepository.findById(id);
    }

    // Créer ou mettre à jour un bâtiment
    public Batiment saveBatiment(Batiment batiment) {
        return batimentRepository.save(batiment);
    }

    // Supprimer un bâtiment
    public void deleteBatiment(Long id) {
        batimentRepository.deleteById(id);
    }

    // Rechercher par nombre minimum d'étages
    public List<Batiment> findByNombreMinEtages(int nombreMinEtages) {
        return batimentRepository.findByNombreDEtagesGreaterThanEqual(nombreMinEtages);
    }

    // Rechercher par surface minimale
    public List<Batiment> findBySurfaceMinimale(float surfaceMinimale) {
        return batimentRepository.findBySurfaceTotaleGreaterThanEqual(surfaceMinimale);
    }

    // Rechercher par année minimale de construction
    public List<Batiment> findByAnneeMinConstruction(int anneeMin) {
        return batimentRepository.findByAnneeDeConstructionGreaterThanEqual(anneeMin);
    }

    // Rechercher par période de construction
    public List<Batiment> findByPeriodeConstruction(int anneeDebut, int anneeFin) {
        return batimentRepository.findByAnneeDeConstructionBetween(anneeDebut, anneeFin);
    }

    // Vérifier si un bâtiment existe
    public boolean existsById(Long id) {
        return batimentRepository.existsById(id);
    }

    // Mettre à jour un bâtiment
    public Batiment updateBatiment(Long id, Batiment batiment) {
        if (batimentRepository.existsById(id)) {
            batiment.setId(id);
            return batimentRepository.save(batiment);
        }
        return null;
    }

    // Compter le nombre total de bâtiments
    public long count() {
        return batimentRepository.count();
    }
} 