package pe.edu.biblioteca.mscliente.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.biblioteca.mscliente.entity.Cliente;
import pe.edu.biblioteca.mscliente.service.ClienteService;
import pe.edu.biblioteca.mscliente.dto.SedeResponse;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        return ResponseEntity.ok(clienteService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {

        return clienteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cliente> guardar(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.guardar(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        clienteService.eliminar(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/sede")
    public ResponseEntity<SedeResponse> obtenerSedeDelCliente(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                clienteService.obtenerSedeDelCliente(id)
        );
    }
}