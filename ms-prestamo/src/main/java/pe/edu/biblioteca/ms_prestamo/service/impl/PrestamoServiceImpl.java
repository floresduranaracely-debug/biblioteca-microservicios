package pe.edu.biblioteca.ms_prestamo.service.impl;

import org.springframework.stereotype.Service;
import pe.edu.biblioteca.ms_prestamo.dto.PrestamoDTO;
import pe.edu.biblioteca.ms_prestamo.entity.Prestamo;
import pe.edu.biblioteca.ms_prestamo.mapper.PrestamoMapper;
import pe.edu.biblioteca.ms_prestamo.repository.PrestamoRepository;
import pe.edu.biblioteca.ms_prestamo.service.PrestamoService;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    private final PrestamoRepository prestamoRepository;
    private final PrestamoMapper prestamoMapper;
    private final RestTemplate restTemplate;

    public PrestamoServiceImpl(PrestamoRepository prestamoRepository,
                               PrestamoMapper prestamoMapper,
                               RestTemplate restTemplate) {

        this.prestamoRepository = prestamoRepository;
        this.prestamoMapper = prestamoMapper;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<PrestamoDTO> listar() {
        return prestamoRepository.findAll()
                .stream()
                .map(prestamoMapper::toDTO)
                .toList();
    }

    @Override
    public PrestamoDTO buscarPorId(Long id) {

        Prestamo prestamo = prestamoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));

        return prestamoMapper.toDTO(prestamo);
    }

    @Override
    public PrestamoDTO guardar(PrestamoDTO dto) {
        //verificar que el libro existe
        restTemplate.getForObject(
                "http://localhost:8085/libros/" + dto.getLibroId(),
                Object.class
        );

        Prestamo prestamo = prestamoMapper.toEntity(dto);

        Prestamo guardado = prestamoRepository.save(prestamo);

        return prestamoMapper.toDTO(guardado);
    }

    @Override
    public PrestamoDTO actualizar(Long id, PrestamoDTO dto) {

        Prestamo prestamo = prestamoMapper.toEntity(dto);

        prestamo.setId(id);

        Prestamo actualizado = prestamoRepository.save(prestamo);

        return prestamoMapper.toDTO(actualizado);
    }

    @Override
    public void eliminar(Long id) {

        prestamoRepository.deleteById(id);

    }
}
