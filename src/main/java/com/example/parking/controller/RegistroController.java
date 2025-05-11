package com.example.parking.controller;

import com.example.parking.model.entity.Registro;
import com.example.parking.model.entity.Vehiculo;
import com.example.parking.service.RegistroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/registro")
@CrossOrigin(origins = "http://localhost:3000")
public class RegistroController {

    private final RegistroService registroService;

    // Constructor para inyección de dependencia
    public RegistroController(RegistroService registroService) {
        this.registroService = registroService;
    }

    /**
     * Endpoint para registrar la entrada de un vehículo.
     * @param payload Un mapa con los datos del vehículo: placa, modelo, color.
     * @return Respuesta HTTP indicando éxito o error.
     */
    @PostMapping("/entrada")
    public ResponseEntity<String> registrarEntrada(@RequestBody Map<String, String> payload) {
    String placa = payload.get("placa");
    String modelo = payload.get("modelo");
    String color = payload.get("color");

    // Validación de datos
    if (placa == null || placa.isEmpty() || modelo == null || modelo.isEmpty() || color == null || color.isEmpty()) {
        return ResponseEntity.badRequest().body("Todos los campos (placa, modelo, color) son obligatorios.");
    }

    try {
        registroService.registrarEntrada(placa, modelo, color);
        return ResponseEntity.ok("Entrada registrada correctamente.");
    } catch (RuntimeException e) {
        return ResponseEntity.badRequest().body("Error registrando el vehículo: " + e.getMessage());
    }
}

    /**
     * Endpoint para registrar la salida de un vehículo.
     * @param payload Un mapa con los datos del vehículo: placa.
     * @return Respuesta HTTP indicando éxito o error.
     */
    @PostMapping("/salida")
    public ResponseEntity<String> registrarSalida(@RequestBody Map<String, String> payload) {
        String placa = payload.get("placa");

        // Validación de datos
        if (placa == null || placa.isEmpty()) {
            return ResponseEntity.badRequest().body("La placa no puede estar vacía.");
        }

        try {
            Registro registro = registroService.registrarSalidaPorPlaca(placa);
            return ResponseEntity.ok("Salida registrada correctamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Error registrando la salida: " + e.getMessage());
        }
    }

    /**
     * Endpoint para consultar el estado de las celdas.
     * @return Respuesta HTTP con el estado de las celdas.
     */
    @GetMapping("/estado-celdas")
    public ResponseEntity<?> obtenerEstadoCeldas() {
        try {
            return ResponseEntity.ok(registroService.obtenerEstadoCeldas());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Error consultando el estado de las celdas: " + e.getMessage());
        }
    }
}