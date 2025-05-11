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
    public Registro registrarSalida(Long idVehiculo) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Registro registrarSalidaPorPlaca(String placa) {
        Vehiculo vehiculo = vehiculoRepository.findByPlaca(placa)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado con la placa: " + placa));

        Registro registro = registroRepository.findByVehiculoAndHoraSalidaIsNull(vehiculo)
                .orElseThrow(() -> new RuntimeException("No hay registro de entrada activo para este vehículo."));

        registro.setFechaHoraSalida(LocalDateTime.now());

        Celda celda = registro.getCelda();
        celda.setDisponibilidad("LIBRE");
        celda.setDisponible(true);
        celdaRepository.save(celda);

        return registroRepository.save(registro);
    }
}
