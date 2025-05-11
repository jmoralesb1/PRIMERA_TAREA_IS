package com.example.parking.service;

import com.example.parking.model.entity.Registro;
import com.example.parking.model.entity.Vehiculo;

public interface RegistroService {

    // Método para registrar la entrada de un vehículo
    void registrarEntrada(String placa, String modelo, String color);

    // Método para registrar la salida de un vehículo
    Registro registrarSalidaPorPlaca(String placa);

    // Método para obtener el estado de las celdas
    Object obtenerEstadoCeldas();
    // Método para obtener los vehículos activos
    List<Vehiculo> obtenerVehiculosActivos();

}