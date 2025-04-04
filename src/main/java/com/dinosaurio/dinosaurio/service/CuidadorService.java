package com.dinosaurio.dinosaurio.service;

import com.dinosaurio.dinosaurio.entity.Cuidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dinosaurio.dinosaurio.repository.CuidadorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CuidadorService {

    @Autowired
    private CuidadorRepository cuidadorRepo;

    public List<Cuidador> listarTodos() {
        return cuidadorRepo.findAll();
    }

    public Cuidador guardar(Cuidador cuidador) {
        return cuidadorRepo.save(cuidador);
    }

    public Optional<Cuidador> buscarPorId(int id) {
        return cuidadorRepo.findById(id);
    }

    public void eliminar(int id) {
        cuidadorRepo.deleteById(id);
    }
}
