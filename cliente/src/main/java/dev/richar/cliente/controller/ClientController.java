package dev.richar.cliente.controller;

import dev.richar.cliente.model.entity.Client;
import dev.richar.cliente.model.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clients")
@CrossOrigin(origins = "*")
public class ClientController {

    private final IClientService clientService;

    @GetMapping("")
    @CircuitBreaker(name = "clientService", fallbackMethod = "fallbackGetAllClients")
    public ResponseEntity<?> getAllClients() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<?> createClient(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.save(client));
    }

    public ResponseEntity<?> fallbackGetAllClients(Throwable t) {
        String mensaje = "🚨 Circuito activado. Servicio no disponible. Causa: " + t.getMessage();
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(mensaje);
    }
}
