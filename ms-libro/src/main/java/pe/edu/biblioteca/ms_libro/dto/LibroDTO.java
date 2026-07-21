package pe.edu.biblioteca.ms_libro.dto;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class LibroDTO {

    private Long id;
    private String titulo;
    private String autor;
    private String editorial;
    private String categoria;
    private Boolean disponible;

}