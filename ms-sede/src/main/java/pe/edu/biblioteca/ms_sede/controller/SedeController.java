package pe.edu.biblioteca.ms_sede.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.biblioteca.ms_sede.entity.Sede;
import pe.edu.biblioteca.ms_sede.service.SedeService;

import java.util.List;

@RestController
@RequestMapping("/api/sedes")
@RequiredArgsConstructor
public class SedeController {

    private final SedeService sedeService;

    @GetMapping
    public ResponseEntity<List<Sede>> listar() {
        return ResponseEntity.ok(sedeService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sede> buscarPorId(@PathVariable Long id) {

        return sedeService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Sede> guardar(@RequestBody Sede sede) {
        return ResponseEntity.ok(sedeService.guardar(sede));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        sedeService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}