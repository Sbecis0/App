package com.dinosaurio.dinosaurio.service;

import com.dinosaurio.dinosaurio.entity.Habitat;
import com.dinosaurio.dinosaurio.repository.HabitatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dinosaurio.dinosaurio.repository.HabitatRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HabitatService {

    @Autowired
    private HabitatRepository habitatRepo;

    public List<Habitat> listarTodos() {
        return habitatRepo.findAll();
    }

    public Habitat guardar(Habitat habitat) {
        return habitatRepo.save(habitat);
    }

    public Optional<Habitat> buscarPorId(int id) {
        return habitatRepo.findById(id);
    }

    public void eliminar(int id) {
        habitatRepo.deleteById(id);
    }
}
