package com.example.parking.controller;

import com.example.parking.model.entity.Registro;
import com.example.parking.service.RegistroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/registro")
@CrossOrigin(origins = "http://localhost:3000")
public class RegistroController {

    private final RegistroService registroService;

    public RegistroController(RegistroService registroService) {
        this.registroService = registroService;
    }

    @PostMapping("/salida")
    public ResponseEntity<String> salidaVehiculo(@RequestBody Map<String, String> payload) {
        String placa = payload.get("placa");
        if (placa == null || placa.isEmpty()) {
            return ResponseEntity.badRequest().body("La placa no puede estar vacía.");
        }

        try {
            Registro registro = registroService.registrarSalidaPorPlaca(placa);
            return ResponseEntity.ok("Salida registrada correctamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
