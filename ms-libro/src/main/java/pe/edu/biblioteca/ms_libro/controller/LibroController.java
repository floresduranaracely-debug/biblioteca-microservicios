package pe.edu.biblioteca.ms_libro.controller;

import org.springframework.web.bind.annotation.*;
import pe.edu.biblioteca.ms_libro.dto.LibroDTO;
import pe.edu.biblioteca.ms_libro.service.LibroService;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<LibroDTO> listar() {
        return libroService.listar();
    }

    @GetMapping("/{id}")
    public LibroDTO buscarPorId(@PathVariable Long id) {
        return libroService.buscarPorId(id);
    }

    @PostMapping
    public LibroDTO guardar(@RequestBody LibroDTO libroDTO) {
        return libroService.guardar(libroDTO);
    }

    @PutMapping("/{id}")
    public LibroDTO actualizar(@PathVariable Long id,
                               @RequestBody LibroDTO libroDTO) {
        return libroService.actualizar(id, libroDTO);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        libroService.eliminar(id);
    }
}