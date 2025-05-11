package com.example.parking.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String placa;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String color;

    @ManyToOne
    @JoinColumn(name = "id_celda")
    private Celda celda;

    // Constructor vacío (requerido por JPA)
    public Vehiculo() {
    }

    // Constructor con parámetros
    public Vehiculo(String placa, String tipo, String color, Celda celda) {
        this.placa = placa;
        this.tipo = tipo;
        this.color = color;
        this.celda = celda;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Celda getCelda() {
        return celda;
    }

    public void setCelda(Celda celda) {
        this.celda = celda;
    }

    // Para depuración y consola
    @Override
    public String toString() {
        return "Vehiculo{" +
                "id=" + id +
                ", placa='" + placa + '\'' +
                ", tipo='" + tipo + '\'' +
                ", color='" + color + '\'' +
                ", celda=" + (celda != null ? celda.getNumero() : "null") +
                '}';
    }
}

