package dev.richar.cliente.controller;

import dev.richar.cliente.model.entity.Client;
import dev.richar.cliente.model.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clients")
@CrossOrigin(origins = "*")
public class ClientController {

    private final IClientService clientService;

    @GetMapping("")
    public ResponseEntity<?> getAllClients() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<?> createClient(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.save(client));
    }
}
