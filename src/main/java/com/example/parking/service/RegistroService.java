package com.example.parking.service;

import com.example.parking.model.entity.Registro;

public interface RegistroService {

    // Método para registrar la entrada de un vehículo
    void registrarEntrada(String placa, String modelo, String color);

    // Método para registrar la salida de un vehículo
    Registro registrarSalidaPorPlaca(String placa);

    // Método para obtener el estado de las celdas
    Object obtenerEstadoCeldas();
}