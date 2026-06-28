package pe.edu.biblioteca.ms_prestamo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreAlumno;

    private String codigoAlumno;

    private Long libroId;

    private LocalDate fechaPrestamo;

    private LocalDate fechaDevolucion;
}