package com.yamila.Yamila.Service;

import com.yamila.Yamila.Entity.Persona;
import com.yamila.Yamila.Interface.IPersonaService;
import com.yamila.Yamila.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IPersonaService {
    
    @Autowired
    IPersonaRepository ipersonaRepository;
    
    @Override
    public List<Persona> getPersonas() {
        List<Persona> personas = ipersonaRepository.findAll();
        return personas;
    }
    
    @Override
    public Persona findPersona(Long id) {
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
    }
    
    @Override
    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);
    }
    
    @Override
    public void deletePersona(Long id) {
        ipersonaRepository.deleteById(id);
    }
    
}
