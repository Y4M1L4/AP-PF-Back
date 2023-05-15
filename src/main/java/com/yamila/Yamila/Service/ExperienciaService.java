package com.yamila.Yamila.Service;

import com.yamila.Yamila.Entity.Experiencia;
import com.yamila.Yamila.Repository.ExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {

    @Autowired
    ExperienciaRepository experienciaRepository;

    public List<Experiencia> getAll() {
        return experienciaRepository.findAll();
    }

    public Optional<Experiencia> getById(int id) {
        return experienciaRepository.findById(id);
    }

    public Optional<Experiencia> getByNombre(String nombre) {
        return experienciaRepository.findByNombre(nombre);
    }

    public void save(Experiencia exp) {
        experienciaRepository.save(exp);
    }

    public void delete(int id) {
        experienciaRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return experienciaRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return experienciaRepository.existsByNombre(nombre);
    }
}
