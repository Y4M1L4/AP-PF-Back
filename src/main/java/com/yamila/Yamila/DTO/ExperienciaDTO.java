package com.yamila.Yamila.DTO;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExperienciaDTO {

    @NotBlank
    private String nombre;

    @NotBlank
    private String descripcion;

    @NotBlank
    private String tipoEmpleo;
    
    @NotBlank
    private boolean esTrabajoActual;

    public ExperienciaDTO() {
    }

    public ExperienciaDTO(String nombre, String descripcion, String tipoEmpleo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoEmpleo = tipoEmpleo;
    }

    
}
