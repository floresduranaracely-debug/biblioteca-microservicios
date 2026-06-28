package pe.edu.biblioteca.ms_prestamo.controller;

import org.springframework.web.bind.annotation.*;
import pe.edu.biblioteca.ms_prestamo.dto.PrestamoDTO;
import pe.edu.biblioteca.ms_prestamo.service.PrestamoService;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @GetMapping
    public List<PrestamoDTO> listar() {
        return prestamoService.listar();
    }

    @GetMapping("/{id}")
    public PrestamoDTO buscar(@PathVariable Long id) {
        return prestamoService.buscarPorId(id);
    }

    @PostMapping
    public PrestamoDTO guardar(@RequestBody PrestamoDTO dto) {
        return prestamoService.guardar(dto);
    }

    @PutMapping("/{id}")
    public PrestamoDTO actualizar(@PathVariable Long id,
                                  @RequestBody PrestamoDTO dto) {
        return prestamoService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        prestamoService.eliminar(id);
    }
}
