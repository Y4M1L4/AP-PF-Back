package com.yamila.Yamila.Controller;

import com.yamila.Yamila.DTO.ExperienciaDTO;
import com.yamila.Yamila.Entity.Experiencia;
import com.yamila.Yamila.Security.Controller.Mensaje;
import com.yamila.Yamila.Service.ExperienciaService;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experiencias")
@CrossOrigin(origins = {"http://localhost:4200/", "https://ap-frontend-becca.web.app/"})
public class ExperienciaController {

    @Autowired
    ExperienciaService experienciaService;

    @GetMapping("")
    public ResponseEntity<List<Experiencia>> getAll() {
        List<Experiencia> list = experienciaService.getAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable int id) {
        Optional<Experiencia> experiencia = experienciaService.getById(id);
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody ExperienciaDTO expDTO) {
        if (StringUtils.isBlank(expDTO.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (experienciaService.existsByNombre(expDTO.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = new Experiencia(expDTO.getNombre(), expDTO.getDescripcion(), expDTO.getTipoEmpleo());

        if (expDTO.isEsTrabajoActual()) {
            experiencia.setEsTrabajoActual(true);
        }

        experienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ExperienciaDTO expDTO) {
        // Validando si existe el ID
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        // Validando el nombre de la experiencia
        if (experienciaService.existsByNombre(expDTO.getNombre()) && experienciaService.getByNombre(expDTO.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        // El campo nombre no puede estar vacio
        if (StringUtils.isBlank(expDTO.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = experienciaService.getById(id).get();
        experiencia.setNombre(expDTO.getNombre());
        experiencia.setDescripcion(expDTO.getDescripcion());
        experiencia.setTipoEmpleo(expDTO.getTipoEmpleo());
        if (expDTO.isEsTrabajoActual()) {
            experiencia.setEsTrabajoActual(true);
        }

        experienciaService.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        // Validando si existe el ID
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        experienciaService.delete(id);

        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
}
