package com.example.parking.controller;

import com.example.parking.model.entity.Registro;
import com.example.parking.model.entity.Vehiculo;
import com.example.parking.service.RegistroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/registro")
@CrossOrigin(origins = "http://localhost:3000")
public class RegistroController {

    private final RegistroService registroService;

    public RegistroController(RegistroService registroService) {
        this.registroService = registroService;
    }

    @PostMapping("/entrada")
    public ResponseEntity<String> registrarEntrada(@RequestBody Map<String, String> payload) {
        String placa = payload.get("placa");
        String tipo = payload.get("tipo");
        String color = payload.get("color");

        if (placa == null || placa.isEmpty() || tipo == null || tipo.isEmpty() || color == null || color.isEmpty()) {
            return ResponseEntity.badRequest().body("Todos los campos (placa, tipo, color) son obligatorios.");
        }

        try {
            registroService.registrarEntrada(placa, tipo, color);
            return ResponseEntity.ok("Entrada registrada correctamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Error registrando el vehículo: " + e.getMessage());
        }
    }

    @PostMapping("/salida")
    public ResponseEntity<String> registrarSalida(@RequestBody Map<String, String> payload) {
        String placa = payload.get("placa");

        if (placa == null || placa.isEmpty()) {
            return ResponseEntity.badRequest().body("La placa no puede estar vacía.");
        }

        try {
            registroService.registrarSalidaPorPlaca(placa);
            return ResponseEntity.ok("Salida registrada correctamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Error registrando la salida: " + e.getMessage());
        }
    }

    @GetMapping("/vehiculos-activos")
    public ResponseEntity<?> obtenerVehiculosActivos() {
        try {
            List<Vehiculo> vehiculosActivos = registroService.obtenerVehiculosActivos();
            return ResponseEntity.ok(vehiculosActivos);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Error obteniendo vehículos activos: " + e.getMessage());
        }
    }
}