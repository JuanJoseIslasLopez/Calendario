package com.calendario.calendario.controller;

import com.calendario.calendario.domain.servicio.ServiciosPermisos;
import com.calendario.calendario.persistence.model.Permisos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/permisos")
public class ControllerPermisos {

    private final ServiciosPermisos serviciosPermisos;

    @Autowired
    public ControllerPermisos(ServiciosPermisos serviciosPermisos) { this.serviciosPermisos = serviciosPermisos; }

    @GetMapping
    public List<Permisos> getPermisos() {
        return serviciosPermisos.getPermisos();
    }

    @PostMapping
    public void registerNewPermisos(@RequestBody Permisos permisos) {
        serviciosPermisos.addNewPermisos(permisos);
    }

    @DeleteMapping(path = "{permisosId}")
    public void deletePermisos(
            @PathVariable("permisosId") Long permisosId) {
        serviciosPermisos.deletePermisos(permisosId);
    }
    @PutMapping
    public void updatePermisos(
            @RequestBody Permisos permisos) {
        serviciosPermisos.updatePermisos(permisos);
    }
}
