package pe.edu.biblioteca.mscliente.dto;

import lombok.Data;

@Data
public class SedeResponse {

    private Long id;
    private String nombre;
    private String direccion;
    private String ciudad;
    private Boolean estado;
}