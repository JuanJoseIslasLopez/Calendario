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

    @DeleteMapping(path = "{agendaId}")
    public void deleteAgenda(
            @PathVariable("agendaId") Long agendaId) {
        serviciosAgenda.deleteAgenda(agendaId);
    }
    @PutMapping(path = "{agendaId}")
    public void updateAgenda(
           @RequestBody Agenda agenda) {
        try {
            serviciosAgenda.updateAgenda(agenda);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
