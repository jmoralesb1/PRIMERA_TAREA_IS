package com.example.parking.service;

import com.example.parking.model.entity.Celda;
import com.example.parking.model.entity.Vehiculo;
import com.example.parking.model.repository.CeldaRepository;
import com.example.parking.model.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private CeldaRepository celdaRepository;

    public Vehiculo crearVehiculoConCelda(Vehiculo vehiculo) {
    Celda celdaDisponible = celdaRepository.findFirstByDisponibilidadAndDisponible("LIBRE", true)
            .orElseThrow(() -> new RuntimeException("No hay celdas disponibles."));

    System.out.println("Celda disponible encontrada: " + celdaDisponible.getNumero());
    celdaDisponible.setDisponibilidad("OCUPADA");
    celdaDisponible.setDisponible(false);
    celdaRepository.save(celdaDisponible);

    vehiculo.setCelda(celdaDisponible);
    return vehiculoRepository.save(vehiculo);
}

    public List<Vehiculo> obtenerTodos() {
        return vehiculoRepository.findAll();
    }
}
