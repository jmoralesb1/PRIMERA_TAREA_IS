package com.example.parking.service.impl;

import com.example.parking.model.entity.Celda;
import com.example.parking.model.repository.CeldaRepository;
import com.example.parking.service.CeldaService;
import org.springframework.stereotype.Service;

@Service
public class CeldaServiceImpl implements CeldaService {

    private final CeldaRepository celdaRepository;

    public CeldaServiceImpl(CeldaRepository celdaRepository) {
        this.celdaRepository = celdaRepository;
    }

    @Override
    public Celda asignarCeldaDisponible() {
    // Encuentra la primera celda disponible
    return celdaRepository.findFirstByDisponibilidadAndDisponible("LIBRE", true)
            .orElseThrow(() -> new RuntimeException("No hay celdas disponibles para asignar."));
}

    @Override
    public Celda actualizarCelda(Celda celda) {
        return celdaRepository.save(celda);
    }
}

