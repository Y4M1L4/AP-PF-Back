package com.yamila.Yamila.DTO;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillsDTO {

    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;

    public SkillsDTO() {
    }

    public SkillsDTO(String nombre, int porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

}
