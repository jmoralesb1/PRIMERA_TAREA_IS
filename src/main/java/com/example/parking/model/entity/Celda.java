package com.example.parking.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "celdas")
public class Celda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero", nullable = false, unique = true)
    private String numero;

    @Column(name = "disponible")
    private boolean disponible = true;

    @Column(name = "disponibilidad", nullable = false)
    private String disponibilidad;

    // Constructor vacío (requerido por JPA)
    public Celda() {
    }

    // Constructor con parámetros
    public Celda(String numero, boolean disponible, String disponibilidad) {
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    // Para depuración y consola
    @Override
    public String toString() {
        return "Celda{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", disponible=" + disponible +
                ", disponibilidad='" + disponibilidad + '\'' +
                '}';
    }
}
