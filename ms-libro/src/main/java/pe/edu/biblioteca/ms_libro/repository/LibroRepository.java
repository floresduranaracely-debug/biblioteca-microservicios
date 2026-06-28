package pe.edu.biblioteca.ms_libro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.biblioteca.ms_libro.entity.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

}
