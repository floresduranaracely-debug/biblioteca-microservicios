package pe.edu.biblioteca.mscliente.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.biblioteca.mscliente.client.SedeClient;
import pe.edu.biblioteca.mscliente.dto.SedeResponse;
import pe.edu.biblioteca.mscliente.entity.Cliente;
import pe.edu.biblioteca.mscliente.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final SedeClient sedeClient;

    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente guardar(Cliente cliente) {

        // Verificar que la sede exista
        if (cliente.getSedeId() != null) {
            sedeClient.buscarSede(cliente.getSedeId());
        }

        return clienteRepository.save(cliente);
    }

    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }

    public SedeResponse obtenerSedeDelCliente(Long clienteId) {

        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        if (cliente.getSedeId() == null) {
            throw new RuntimeException("El cliente no tiene una sede asignada");
        }

        return sedeClient.buscarSede(cliente.getSedeId());
    }
}