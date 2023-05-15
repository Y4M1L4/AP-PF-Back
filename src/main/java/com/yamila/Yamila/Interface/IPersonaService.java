package com.yamila.Yamila.Interface;

import com.yamila.Yamila.Entity.Persona;
import java.util.List;

public interface IPersonaService {

    // Traer una lista de personas
    public List<Persona> getPersonas();

    // Buscar una persona por ID
    public Persona findPersona(Long id);

    // Guardar un objeto de tipo Persona
    public void savePersona(Persona persona);

    // Eliminar una persona por ID
    public void deletePersona(Long id);
}
