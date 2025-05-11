package com.example.parking.service.impl;

import com.example.parking.model.entity.Celda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CeldaRepository extends JpaRepository<Celda, Long> {
    Optional<Celda> findFirstByDisponibilidadAndDisponible(String disponibilidad, boolean disponible);
}