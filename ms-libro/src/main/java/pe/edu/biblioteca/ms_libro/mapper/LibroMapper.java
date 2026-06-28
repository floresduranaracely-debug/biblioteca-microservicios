package pe.edu.biblioteca.ms_libro.mapper;

import org.mapstruct.Mapper;
import pe.edu.biblioteca.ms_libro.dto.LibroDTO;
import pe.edu.biblioteca.ms_libro.entity.Libro;

@Mapper(componentModel = "spring")
public interface LibroMapper {

    LibroDTO toDTO(Libro libro);

    Libro toEntity(LibroDTO libroDTO);
}