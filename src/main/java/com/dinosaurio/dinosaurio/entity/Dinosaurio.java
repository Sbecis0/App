package com.dinosaurio.dinosaurio.entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Dinosaurio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String especie;
    private double peso;
    private int edad;

    @ManyToOne
    @JoinColumn(name = "habitat_id")
    private Habitat habitat;

    @ManyToMany
    @JoinTable(
            name = "Dinosaurio_Cuidador",
            joinColumns = @JoinColumn(name = "dinosaurio_id"),
            inverseJoinColumns = @JoinColumn(name = "cuidador_id")
    )
    private List<Cuidador> cuidadores;

    public Dinosaurio() {
    }

    public Dinosaurio(String nombre, String especie, double peso, int edad, Habitat habitat) {
        this.nombre = nombre;
        this.especie = especie;
        this.peso = peso;
        this.edad = edad;
        this.habitat = habitat;
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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    public List<Cuidador> getCuidadores() {
        return cuidadores;
    }

    public void setCuidadores(List<Cuidador> cuidadores) {
        this.cuidadores = cuidadores;
    }

    @Override
    public String toString() {
        return "Dinosaurio{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", peso=" + peso +
                ", edad=" + edad +
                ", habitat=" + (habitat != null ? habitat.getNombre() : "N/A") +
                '}';
    }
}
