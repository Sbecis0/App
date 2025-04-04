package com.dinosaurio.dinosaurio.repository;

import com.dinosaurio.dinosaurio.entity.Habitat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitatRepository extends JpaRepository<Habitat, Integer> {
    // Ejemplo personalizado:
    // List<Habitat> findByTipo(String tipo);
}
