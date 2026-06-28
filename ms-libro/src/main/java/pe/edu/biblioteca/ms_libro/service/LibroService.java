package pe.edu.biblioteca.ms_libro.service;

import pe.edu.biblioteca.ms_libro.dto.LibroDTO;

import java.util.List;

public interface LibroService {

    List<LibroDTO> listar();

    LibroDTO buscarPorId(Long id);

    LibroDTO guardar(LibroDTO libroDTO);

    LibroDTO actualizar(Long id, LibroDTO libroDTO);

    void eliminar(Long id);
}