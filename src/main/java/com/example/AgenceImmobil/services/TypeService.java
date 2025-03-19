package com.example.AgenceImmobil.services;

import com.example.AgenceImmobil.entities.Type;
import com.example.AgenceImmobil.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TypeService {
    
    @Autowired
    private TypeRepository typeRepository;

    // Récupérer tous les types
    public List<Type> getAllTypes() {

        return typeRepository.findAll();
    }

    // Récupérer un type par son ID
    public Optional<Type> getTypeById(Long id) {
        return typeRepository.findById(id);
    }

    // Créer ou mettre à jour un type
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    // Supprimer un type
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }

    // Rechercher par type spécifique
    public List<Type> findByType(String type) {
        return typeRepository.findByType(type);
    }

    // Vérifier si un type existe
    public boolean existsById(Long id) {
        return typeRepository.existsById(id);
    }

    // Mettre à jour un type
    public Type updateType(Long id, Type type) {
        if (typeRepository.existsById(id)) {
            type.setId(id);
            return typeRepository.save(type);
        }
        return null;
    }

    // Compter le nombre total de types
    public long count() {
        return typeRepository.count();
    }

    // Supprimer tous les types
    public void deleteAll() {
        typeRepository.deleteAll();
    }

    // Sauvegarder plusieurs types en même temps
    public List<Type> saveAll(List<Type> types) {
        return typeRepository.saveAll(types);
    }

    // Vérifier si plusieurs types existent
    public boolean existsAllById(Iterable<Long> ids) {
        return typeRepository.findAllById(ids).size() == ((List<Long>)ids).size();
    }
} 