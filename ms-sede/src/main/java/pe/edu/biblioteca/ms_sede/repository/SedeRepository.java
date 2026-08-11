package pe.edu.biblioteca.ms_sede.repository;

import pe.edu.biblioteca.ms_sede.entity.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SedeRepository extends JpaRepository<Sede, Long> {
}