package com.dinosaurio.dinosaurio.controller;

import com.dinosaurio.dinosaurio.entity.Habitat;
import com.dinosaurio.dinosaurio.service.HabitatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;

@Component
public class HabitatController {

    @Autowired
    private HabitatService habitatService;

    public void crearHabitat(String nombre, String tipo, String clima) {
        Habitat habitat = new Habitat(nombre, tipo, clima);
        habitatService.guardar(habitat);
        System.out.println("✅ Hábitat creado.");
    }

    public List<Habitat> listarHabitats() {
        return habitatService.listarTodos();
    }

    public Optional<Habitat> buscarHabitat(int id) {
        return habitatService.buscarPorId(id);
    }

    public void eliminarHabitat(int id) {
        habitatService.eliminar(id);
        System.out.println("🗑️ Hábitat eliminado.");
    }
}
