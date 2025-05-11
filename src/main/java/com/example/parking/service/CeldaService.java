package com.example.parking.service;

import com.example.parking.model.entity.Celda;

public interface CeldaService {
    Celda asignarCeldaDisponible();
    Celda actualizarCelda(Celda celda);
}
