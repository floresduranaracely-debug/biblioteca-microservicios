package pe.edu.biblioteca.ms_sede.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.biblioteca.ms_sede.entity.Sede;
import pe.edu.biblioteca.ms_sede.repository.SedeRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SedeService {

    private final SedeRepository sedeRepository;

    public List<Sede> listar() {
        return sedeRepository.findAll();
    }

    public Optional<Sede> buscarPorId(Long id) {
        return sedeRepository.findById(id);
    }

    public Sede guardar(Sede sede) {
        return sedeRepository.save(sede);
    }

    public void eliminar(Long id) {
        sedeRepository.deleteById(id);
    }
}