package com.yamila.Yamila.Controller;

import com.yamila.Yamila.Entity.Persona;
import com.yamila.Yamila.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/", "https://ap-frontend-becca.web.app/"})
public class PersonaController {

    @Autowired
    IPersonaService ipersonaService;

    @GetMapping("/personas")
    public List<Persona> getPersonas() {
        return ipersonaService.getPersonas();
    }

    @GetMapping("/personas/{id}")
    public Persona getPersonaById(@PathVariable Long id) {
        Persona persona = ipersonaService.findPersona(id);
        return persona;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas")
    public String createPersona(@RequestBody Persona persona) {
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/{id}")
    public Persona updatePersona(@PathVariable Long id,
            @RequestBody Persona newPersona) {

        Persona persona = ipersonaService.findPersona(id);

        persona.setNombre(newPersona.getNombre());
        persona.setApellido(newPersona.getApellido());
        persona.setImg(newPersona.getImg());

        ipersonaService.savePersona(persona);

        return persona;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/{id}")
    public String deletePersona(@PathVariable Long id) {
        ipersonaService.deletePersona(id);
        return "La persona fue borrada correctamente";
    }
}
