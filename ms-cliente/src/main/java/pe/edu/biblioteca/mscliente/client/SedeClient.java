package pe.edu.biblioteca.mscliente.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.biblioteca.mscliente.dto.SedeResponse;

@FeignClient(name = "ms-sede")
public interface SedeClient {

    @GetMapping("/api/sedes/{id}")
    SedeResponse buscarSede(@PathVariable Long id);
}