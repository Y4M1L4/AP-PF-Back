package com.yamila.Yamila.Repository;

import com.yamila.Yamila.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienciaRepository extends JpaRepository<Experiencia, Integer> {

    public Optional<Experiencia> findByNombre(String nombre);

    public boolean existsByNombre(String nombre);
}
