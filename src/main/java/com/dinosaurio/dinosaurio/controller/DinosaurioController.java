package com.dinosaurio.dinosaurio.controller;

import com.dinosaurio.dinosaurio.service.DinosaurioService;
import com.dinosaurio.dinosaurio.entity.Dinosaurio;
import com.dinosaurio.dinosaurio.entity.Habitat;
import com.dinosaurio.dinosaurio.entity.Cuidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.dinosaurio.dinosaurio.repository.DinosaurioRepository;

import java.util.List;
import java.util.Optional;

@Component
public class DinosaurioController {

    @Autowired
    private DinosaurioService dinosaurioService;

    public void crearDinosaurio(String nombre, String especie, double peso, int edad, Habitat habitat) {
        Dinosaurio dino = new Dinosaurio(nombre, especie, peso, edad, habitat);
        dinosaurioService.guardar(dino);
        System.out.println("✅ Dinosaurio creado.");
    }

    public List<Dinosaurio> listarDinosaurios() {
        return dinosaurioService.listarTodos();
    }

    public Optional<Dinosaurio> buscarDinosaurio(int id) {
        return dinosaurioService.buscarPorId(id);
    }

    public void eliminarDinosaurio(int id) {
        dinosaurioService.eliminar(id);
        System.out.println("🗑️ Dinosaurio eliminado.");
    }

    public void asignarCuidadores(Dinosaurio dino, List<Cuidador> cuidadores) {
        dinosaurioService.asignarCuidadores(dino, cuidadores);
        System.out.println("👷‍♂️ Cuidadores asignados.");
    }
}
