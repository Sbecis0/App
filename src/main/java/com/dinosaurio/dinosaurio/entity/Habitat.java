package com.dinosaurio.dinosaurio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import java.util.List;

@Entity
public class Habitat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String tipo;
    private String clima;

    @OneToMany(mappedBy = "habitat", cascade = CascadeType.ALL)
    private List<Dinosaurio> dinosaurios;

    public Habitat() {
    }

    public Habitat(String nombre, String tipo, String clima) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.clima = clima;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public List<Dinosaurio> getDinosaurios() {
        return dinosaurios;
    }

    public void setDinosaurios(List<Dinosaurio> dinosaurios) {
        this.dinosaurios = dinosaurios;
    }

    @Override
    public String toString() {
        return "Habitat{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", clima='" + clima + '\'' +
                '}';
    }
}
