package com.dinosaurio.dinosaurio.repository;

import com.dinosaurio.dinosaurio.entity.Dinosaurio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DinosaurioRepository extends JpaRepository<Dinosaurio, Integer> {
    // Aquí puedes añadir métodos personalizados, por ejemplo:
    // List<Dinosaurio> findByEspecie(String especie);
}
