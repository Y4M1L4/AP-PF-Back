package com.yamila.Yamila.Service;

import com.yamila.Yamila.Entity.Skills;
import com.yamila.Yamila.Repository.SkillsRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class SkillsService {

    @Autowired
    SkillsRepository skillsRepository;

    public List<Skills> getAll() {
        return skillsRepository.findAll();
    }

    public Optional<Skills> getOne(int id) {
        return skillsRepository.findById(id);
    }

    public Optional<Skills> getByNombre(String nombre) {
        return skillsRepository.findByNombre(nombre);
    }

    public void save(Skills skill) {
        skillsRepository.save(skill);
    }

    public void delete(int id) {
        skillsRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return skillsRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return skillsRepository.existsByNombre(nombre);
    }
}
