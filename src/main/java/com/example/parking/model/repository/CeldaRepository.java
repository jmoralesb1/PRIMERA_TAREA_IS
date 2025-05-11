package com.example.parking.model.repository;

import com.example.parking.model.entity.Celda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeldaRepository extends JpaRepository<Celda, Long> {
    // Encuentra la primera celda con una disponibilidad específica
    Celda findFirstByDisponibilidadAndDisponible(String disponibilidad, boolean disponible);
}