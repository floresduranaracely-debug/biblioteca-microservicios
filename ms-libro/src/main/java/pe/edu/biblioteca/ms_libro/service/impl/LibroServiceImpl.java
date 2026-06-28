package pe.edu.biblioteca.ms_libro.service.impl;

import org.springframework.stereotype.Service;
import pe.edu.biblioteca.ms_libro.dto.LibroDTO;
import pe.edu.biblioteca.ms_libro.entity.Libro;
import pe.edu.biblioteca.ms_libro.mapper.LibroMapper;
import pe.edu.biblioteca.ms_libro.repository.LibroRepository;
import pe.edu.biblioteca.ms_libro.service.LibroService;

import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;
    private final LibroMapper libroMapper;

    public LibroServiceImpl(LibroRepository libroRepository, LibroMapper libroMapper) {
        this.libroRepository = libroRepository;
        this.libroMapper = libroMapper;
    }

    @Override
    public List<LibroDTO> listar() {
        return libroRepository.findAll()
                .stream()
                .map(libroMapper::toDTO)
                .toList();
    }

    @Override
    public LibroDTO buscarPorId(Long id) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        return libroMapper.toDTO(libro);
    }

    @Override
    public LibroDTO guardar(LibroDTO libroDTO) {
        Libro libro = libroMapper.toEntity(libroDTO);
        Libro guardado = libroRepository.save(libro);
        return libroMapper.toDTO(guardado);
    }

    @Override
    public LibroDTO actualizar(Long id, LibroDTO libroDTO) {
        Libro libro = libroMapper.toEntity(libroDTO);
        libro.setId(id);
        Libro actualizado = libroRepository.save(libro);
        return libroMapper.toDTO(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        libroRepository.deleteById(id);
    }
}