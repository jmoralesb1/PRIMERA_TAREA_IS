package com.example.parking.model.repository;

import com.example.parking.model.entity.Registro;
import com.example.parking.model.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RegistroRepository extends JpaRepository<Registro, Long> {
    Optional<Registro> findByVehiculoAndFechaHoraSalidaIsNull(Vehiculo vehiculo);

    List<Registro> findByFechaHoraSalidaIsNull();
}