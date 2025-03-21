package com.example.AgenceImmobil.repositories;

import com.example.AgenceImmobil.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
    List<Type> findByType(String type);
} 