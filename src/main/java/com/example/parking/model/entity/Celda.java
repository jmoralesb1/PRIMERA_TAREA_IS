package com.example.parking.model.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "celdas")
public class Celda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private int numero;

    @Column(nullable = false)
    private String disponibilidad; // LIBRE, OCUPADA

    @Column(nullable = false)
    private boolean disponible;

    @OneToMany(mappedBy = "celda")
    private List<Vehiculo> vehiculos;

    // Constructor vacío (requerido por JPA)
    public Celda() {
    }

    // Constructor con parámetros
    public Celda(int numero, boolean disponible, String disponibilidad) { // Cambiado String a int
        this.numero = numero;
        this.disponible = disponible;
        this.disponibilidad = disponibilidad;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getDisponibilidad() {
        return disponibilidad;
    }
    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    public boolean isDisponible() {
        return disponible;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    // Para depuración y consola
    @Override
    public String toString() {
        return "Celda{" +
                "id=" + id +
                ", numero=" + numero + // Ajustado a int
                ", disponible=" + disponible +
                ", disponibilidad='" + disponibilidad + '\'' +
                '}';
    }
}