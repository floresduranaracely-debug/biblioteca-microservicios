package pe.edu.biblioteca.ms_prestamo.mapper;

import org.mapstruct.Mapper;
import pe.edu.biblioteca.ms_prestamo.dto.PrestamoDTO;
import pe.edu.biblioteca.ms_prestamo.entity.Prestamo;

@Mapper(componentModel = "spring")
public interface PrestamoMapper {

    PrestamoDTO toDTO(Prestamo prestamo);

    Prestamo toEntity(PrestamoDTO dto);

}