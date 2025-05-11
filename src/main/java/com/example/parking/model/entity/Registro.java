package com.example.parking.model.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaHoraEntrada;
    private LocalDateTime fechaHoraSalida;

    @ManyToOne
    private Vehiculo vehiculo;

    @ManyToOne
    private Celda celda;

    @Column(name = "hora_salida")
    private LocalDateTime horaSalida;

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }



    // Getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDateTime getFechaHoraEntrada() {
        return fechaHoraEntrada;
    }
    public void setFechaHoraEntrada(LocalDateTime fechaHoraEntrada) {
        this.fechaHoraEntrada = fechaHoraEntrada;
    }
    public LocalDateTime getFechaHoraSalida() {
        return fechaHoraSalida;
    }
    public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    public Celda getCelda() {
        return celda;
    }
    public void setCelda(Celda celda) {
        this.celda = celda;
    }
}