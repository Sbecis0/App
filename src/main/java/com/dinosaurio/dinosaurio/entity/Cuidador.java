package com.dinosaurio.dinosaurio.entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cuidador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String especialidad;

    @ManyToMany(mappedBy = "cuidadores")
    private List<Dinosaurio> dinosaurios;

    public Cuidador() {
    }

    public Cuidador(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Dinosaurio> getDinosaurios() {
        return dinosaurios;
    }

    public void setDinosaurios(List<Dinosaurio> dinosaurios) {
        this.dinosaurios = dinosaurios;
    }

    @Override
    public String toString() {
        return "Cuidador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
}
