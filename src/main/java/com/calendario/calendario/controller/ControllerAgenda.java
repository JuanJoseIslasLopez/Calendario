package com.calendario.calendario.controller;

import com.calendario.calendario.domain.servicio.ServiciosAgenda;
import com.calendario.calendario.persistence.model.Agenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/agendas")
public class ControllerAgenda {

    private final ServiciosAgenda serviciosAgenda;

    @Autowired
    public ControllerAgenda(ServiciosAgenda serviciosAgenda) { this.serviciosAgenda = serviciosAgenda; }

    @GetMapping
    public List<Agenda> getAgenda() {
        return serviciosAgenda.getAgenda();
    }

    @PostMapping
    public void saveAgenda(@RequestBody Agenda agenda) {
        serviciosAgenda.saveAgenda(agenda);
    }

    @DeleteMapping
    public void deleteAgenda(
            @RequestBody Agenda agenda) {
        serviciosAgenda.deleteAgenda(agenda);
    }
    @PutMapping
    public void updateAgenda(
           @RequestBody Agenda agenda) {
            serviciosAgenda.updateAgenda(agenda);
        }

    }

