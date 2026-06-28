package pe.edu.biblioteca.ms_prestamo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.biblioteca.ms_prestamo.entity.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
}