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
import java.util.List;
import java.util.stream.Collectors;

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
    public void registrarEntrada(String placa, String tipo, String color) {
        Vehiculo vehiculo = vehiculoRepository.findByPlaca(placa)
                .orElseGet(() -> vehiculoRepository.save(new Vehiculo(placa, tipo, color)));

        Celda celda = celdaRepository.findFirstByDisponibilidadAndDisponible("LIBRE", true)
                .orElseThrow(() -> new RuntimeException("No hay celdas disponibles para asignar."));

        Registro registro = new Registro();
        registro.setVehiculo(vehiculo);
        registro.setCelda(celda);
        registro.setFechaHoraEntrada(LocalDateTime.now());

        celda.setDisponible(false);
        celda.setDisponibilidad("OCUPADA");
        celdaRepository.save(celda);

        registroRepository.save(registro);
    }

    @Override
    public Registro registrarSalidaPorPlaca(String placa) {
        Vehiculo vehiculo = vehiculoRepository.findByPlaca(placa)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado con la placa: " + placa));

        Registro registro = registroRepository.findByVehiculoAndFechaHoraSalidaIsNull(vehiculo)
                .orElseThrow(() -> new RuntimeException("No hay registro de entrada activo para este vehículo."));

        registro.setFechaHoraSalida(LocalDateTime.now());

        Celda celda = registro.getCelda();
        celda.setDisponible(true);
        celda.setDisponibilidad("LIBRE");
        celdaRepository.save(celda);

        return registroRepository.save(registro);
    }

    @Override
    public List<Vehiculo> obtenerVehiculosActivos() {
        List<Registro> registrosActivos = registroRepository.findByFechaHoraSalidaIsNull();
        return registrosActivos.stream()
                .map(Registro::getVehiculo)
                .collect(Collectors.toList());
    }
}