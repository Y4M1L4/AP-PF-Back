package com.yamila.Yamila.Repository;

import com.yamila.Yamila.Entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillsRepository extends JpaRepository<Skills, Integer> {

    Optional<Skills> findByNombre(String nombre);

    public boolean existsByNombre(String nombre);

}
