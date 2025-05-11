package com.example.parking.service;

import com.example.parking.model.entity.Registro;

public interface RegistroService {
    Registro registrarSalida(Long idVehiculo); // Método previamente implementado

    Registro registrarSalidaPorPlaca(String placa); // Método que estás usando en RegistroServiceImpl
}