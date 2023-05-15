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
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String descripcion;
    private boolean esTrabajoActual;
    private String tipoEmpleo;

//    private fechaInicio;
//    private fechaFin;
//    @ManyToOne
//    @JoinColumn
//    private Persona persona;
    public Experiencia() {
    }

    public Experiencia(String nombre, String descripcion, String tipoEmpleo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoEmpleo = tipoEmpleo;
    }

}
