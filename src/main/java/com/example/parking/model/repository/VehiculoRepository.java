package com.example.parking.model.repository;

import com.example.parking.model.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    Optional<Vehiculo> findByPlaca(String placa); // Método utilizado en RegistroServiceImpl
}