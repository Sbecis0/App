package com.dinosaurio.dinosaurio.repository;

import com.dinosaurio.dinosaurio.entity.Cuidador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuidadorRepository extends JpaRepository<Cuidador, Integer> {
    // Ejemplo personalizado:
    // List<Cuidador> findByEspecialidad(String especialidad);
}
