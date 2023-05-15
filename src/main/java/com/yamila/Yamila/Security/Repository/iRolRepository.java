package com.yamila.Yamila.Security.Repository;

import com.yamila.Yamila.Security.Entity.Rol;
import com.yamila.Yamila.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
