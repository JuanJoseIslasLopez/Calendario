package com.calendario.calendario.controller;

import com.calendario.calendario.domain.servicio.ServiciosTipoUsuario;
import com.calendario.calendario.persistence.model.TipoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/tipousuarios")
public class ControllerTipoUsuario {

    private final ServiciosTipoUsuario serviciosTipoUsuario;

    @Autowired
    public ControllerTipoUsuario(ServiciosTipoUsuario serviciosTipoUsuario) { this.serviciosTipoUsuario = serviciosTipoUsuario; }

    @GetMapping
    public List<TipoUsuario> getTipoUsuario() {
        return serviciosTipoUsuario.getTipoUsuario();
    }

    @PostMapping
    public void registerNewTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
        serviciosTipoUsuario.addNewTipoUsuario(tipoUsuario);
    }

    @DeleteMapping(path = "{tipoUsuarioId}")
    public void deleteTipoUsuario(
            @PathVariable("tipoUsuarioId") Long tipoUsuarioId) {
        serviciosTipoUsuario.deleteTipoUsuario(tipoUsuarioId);
    }
    @PutMapping
    public void updateTipoUsuario(
            @RequestBody TipoUsuario tipoUsuario) {
        serviciosTipoUsuario.updateTipoUsuario(tipoUsuario);
    }
}
