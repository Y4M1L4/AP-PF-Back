package com.yamila.Yamila.Controller;

import com.yamila.Yamila.DTO.SkillsDTO;
import com.yamila.Yamila.Entity.Skills;
import com.yamila.Yamila.Security.Controller.Mensaje;
import com.yamila.Yamila.Service.SkillsService;
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
@CrossOrigin(origins = {"http://localhost:4200/", "https://ap-frontend-becca.web.app/"})
@RequestMapping("/skills")
public class SkillsController {

    @Autowired
    SkillsService skillService;

    @GetMapping("")
    public ResponseEntity<List<Skills>> getAll() {
        List<Skills> list = skillService.getAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skills> getById(@PathVariable int id) {
        Optional<Skills> skills = skillService.getOne(id);
        return new ResponseEntity(skills, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody SkillsDTO skillsDTO) {
        if (StringUtils.isBlank(skillsDTO.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (skillService.existsByNombre(skillsDTO.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa habilidad existe"), HttpStatus.BAD_REQUEST);
        }

        Skills skills = new Skills(skillsDTO.getNombre(), skillsDTO.getPorcentaje());

        skillService.save(skills);
        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody SkillsDTO skillsDTO) {
        // Validando si existe el ID
        if (!skillService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        // Validando el nombre de la experiencia
        if (skillService.existsByNombre(skillsDTO.getNombre()) && skillService.getByNombre(skillsDTO.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        // El campo nombre no puede estar vacio
        if (StringUtils.isBlank(skillsDTO.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Skills skills = skillService.getOne(id).get();
        skills.setNombre(skillsDTO.getNombre());
        skills.setPorcentaje(skillsDTO.getPorcentaje());

        skillService.save(skills);

        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        // Validando si existe el ID
        if (!skillService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        skillService.delete(id);

        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }
}
