package com.yamila.Yamila.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String urlImageLogo;
    private int porcentaje;

    public Skills() {
    }

    public Skills(String nombre, String urlImageLogo, int porcentaje) {
        this.nombre = nombre;
        this.urlImageLogo = urlImageLogo;
        this.porcentaje = porcentaje;
    }

}
