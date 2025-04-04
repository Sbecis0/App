package com.dinosaurio.dinosaurio.service;
import com.dinosaurio.dinosaurio.entity.Dinosaurio;
import com.dinosaurio.dinosaurio.entity.Habitat;
import com.dinosaurio.dinosaurio.entity.Cuidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dinosaurio.dinosaurio.repository.DinosaurioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DinosaurioService {

    @Autowired
    private DinosaurioRepository dinosaurioRepo;

    public List<Dinosaurio> listarTodos() {
        return dinosaurioRepo.findAll();
    }

    public Dinosaurio guardar(Dinosaurio dino) {
        return dinosaurioRepo.save(dino);
    }

    public Optional<Dinosaurio> buscarPorId(int id) {
        return dinosaurioRepo.findById(id);
    }

    public void eliminar(int id) {
        dinosaurioRepo.deleteById(id);
    }

    public void asignarHabitat(Dinosaurio dino, Habitat habitat) {
        dino.setHabitat(habitat);
        dinosaurioRepo.save(dino);
    }

    public void asignarCuidadores(Dinosaurio dino, List<Cuidador> cuidadores) {
        dino.setCuidadores(cuidadores);
        dinosaurioRepo.save(dino);
    }
}
