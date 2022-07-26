package com.calendario.calendario.controller;

import com.calendario.calendario.domain.servicio.ServiciosUsuario;
import com.calendario.calendario.persistence.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/usuarios")
public class ControllerUsuario {

    private final ServiciosUsuario serviciosUsuario;

    @Autowired
    public ControllerUsuario(ServiciosUsuario serviciosUsuario) { this.serviciosUsuario = serviciosUsuario; }

    @GetMapping
    public List<Usuario> getUsuario() {
        return serviciosUsuario.getUsuario();
    }

    @PostMapping
    public void registerNewUsuario(@RequestBody Usuario usuario) {
        serviciosUsuario.addNewUsuario(usuario);
    }

    @DeleteMapping(path = "{usuarioId}")
    public void deleteUsuario(
            @PathVariable("usuarioId") Long usuarioId) {
        serviciosUsuario.deleteUsuario(usuarioId);
    }
    @PutMapping
    public void updateUsuario(
            @RequestBody Usuario usuario) {
        serviciosUsuario.updateUsuario(usuario);
    }
}
