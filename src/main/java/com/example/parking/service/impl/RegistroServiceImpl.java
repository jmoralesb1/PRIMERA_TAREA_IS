package com.example.parking.service.impl;

import com.example.parking.model.entity.Registro;
import com.example.parking.model.entity.Vehiculo;
import com.example.parking.model.entity.Celda;
import com.example.parking.model.repository.RegistroRepository;
import com.example.parking.model.repository.VehiculoRepository;
import com.example.parking.model.repository.CeldaRepository;
import com.example.parking.service.RegistroService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegistroServiceImpl implements RegistroService {

    private final RegistroRepository registroRepository;
    private final VehiculoRepository vehiculoRepository;
    private final CeldaRepository celdaRepository;

    public RegistroServiceImpl(RegistroRepository registroRepository,
                                VehiculoRepository vehiculoRepository,
                                CeldaRepository celdaRepository) {
        this.registroRepository = registroRepository;
        this.vehiculoRepository = vehiculoRepository;
        this.celdaRepository = celdaRepository;
    }

    @Override
    public void registrarEntrada(String placa, String modelo, String color) {
        // Buscar o crear vehículo
        Vehiculo vehiculo = vehiculoRepository.findByPlaca(placa)
                .orElseGet(() -> vehiculoRepository.save(new Vehiculo(placa, modelo, color)));

        // Asignar celda disponible
        Celda celda = celdaRepository.findFirstByDisponibilidadAndDisponible("LIBRE", true)
                .orElseThrow(() -> new RuntimeException("No hay celdas disponibles para asignar."));

        // Crear registro
        Registro registro = new Registro();
        registro.setVehiculo(vehiculo);
        registro.setCelda(celda);
        registro.setFechaHoraEntrada(LocalDateTime.now());

        // Marcar celda como ocupada
        celda.setDisponible(false);
        celda.setDisponibilidad("OCUPADA");
        celdaRepository.save(celda);

        // Guardar registro
        registroRepository.save(registro);
    }

    @Override
    public Registro registrarSalidaPorPlaca(String placa) {
        // Buscar vehículo por placa
        Vehiculo vehiculo = vehiculoRepository.findByPlaca(placa)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado con la placa: " + placa));

        // Buscar registro activo (sin hora de salida)
        Registro registro = registroRepository.findByVehiculoAndHoraSalidaIsNull(vehiculo)
                .orElseThrow(() -> new RuntimeException("No hay registro de entrada activo para este vehículo."));

        // Registrar hora de salida
        registro.setFechaHoraSalida(LocalDateTime.now());

        // Liberar la celda
        Celda celda = registro.getCelda();
        celda.setDisponible(true);
        celda.setDisponibilidad("LIBRE");
        celdaRepository.save(celda);

        // Guardar el registro actualizado
        return registroRepository.save(registro);
    }

    @Override
    public Object obtenerEstadoCeldas() {
        // Consultar todas las celdas y devolver su estado
        return celdaRepository.findAll();
    }
}