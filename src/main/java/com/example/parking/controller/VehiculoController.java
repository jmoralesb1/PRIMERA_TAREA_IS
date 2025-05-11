package com.example.parking.controller;

import com.example.parking.model.entity.Vehiculo;
import com.example.parking.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
@CrossOrigin(origins = "*")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @PostMapping("/crear")
    public ResponseEntity<String> crearVehiculo(@RequestBody Vehiculo vehiculo) {
        System.out.println("Vehiculo recibido: " + vehiculo);
        Vehiculo creado = vehiculoService.crearVehiculoConCelda(vehiculo);
        if (creado != null) {
            String mensaje = "Vehículo registrado. Celda asignada: " + creado.getCelda().getNumero();
            return ResponseEntity.ok(mensaje);
        } else {
            return ResponseEntity.badRequest().body("No hay celdas disponibles.");
        }
}


    @GetMapping("/all")
    public List<Vehiculo> obtenerVehiculos() {
        return vehiculoService.obtenerTodos();
    }
}

