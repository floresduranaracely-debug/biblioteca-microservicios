package pe.edu.biblioteca.ms_prestamo.service;

import pe.edu.biblioteca.ms_prestamo.dto.PrestamoDTO;

import java.util.List;

public interface PrestamoService {

    List<PrestamoDTO> listar();

    PrestamoDTO buscarPorId(Long id);

    PrestamoDTO guardar(PrestamoDTO dto);

    PrestamoDTO actualizar(Long id, PrestamoDTO dto);

    void eliminar(Long id);

}