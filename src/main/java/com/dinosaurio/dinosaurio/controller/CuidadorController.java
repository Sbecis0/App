package com.dinosaurio.dinosaurio.controller;

import com.dinosaurio.dinosaurio.entity.Cuidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.dinosaurio.dinosaurio.service.CuidadorService;

import java.util.List;
import java.util.Optional;

@Component
public class CuidadorController {

    @Autowired
    private CuidadorService cuidadorService;

    public void crearCuidador(String nombre, String especialidad) {
        Cuidador cuidador = new Cuidador(nombre, especialidad);
        cuidadorService.guardar(cuidador);
        System.out.println("✅ Cuidador creado.");
    }

    public List<Cuidador> listarCuidadores() {
        return cuidadorService.listarTodos();
    }

    public Optional<Cuidador> buscarCuidador(int id) {
        return cuidadorService.buscarPorId(id);
    }

    public void eliminarCuidador(int id) {
        cuidadorService.eliminar(id);
        System.out.println("🗑️ Cuidador eliminado.");
    }
}
