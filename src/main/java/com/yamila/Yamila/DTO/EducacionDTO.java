package com.yamila.Yamila.DTO;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EducacionDTO {

    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    @NotBlank
    private boolean esActual;

    public EducacionDTO() {
    }

    public EducacionDTO(String nombre, String descripcion, boolean esActual) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.esActual = esActual;
    }

}
