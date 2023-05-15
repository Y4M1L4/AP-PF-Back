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
    private String urlImageLogo;
    @NotBlank
    private int porcentaje;

    public SkillsDTO() {
    }

    public SkillsDTO(String nombre, String urlImageLogo, int porcentaje) {
        this.nombre = nombre;
        this.urlImageLogo = urlImageLogo;
        this.porcentaje = porcentaje;
    }

}
