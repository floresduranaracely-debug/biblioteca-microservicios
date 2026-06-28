package pe.edu.biblioteca.ms_prestamo.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrestamoDTO {

    private Long id;
    private String nombreAlumno;
    private String codigoAlumno;
    private Long libroId;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
}