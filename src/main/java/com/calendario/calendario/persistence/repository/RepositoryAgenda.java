package com.calendario.calendario.persistence.repository;

import com.calendario.calendario.persistence.model.Permisos;

import java.util.Optional;

public interface RepositoryAgenda
        extends JpaRepository<Agenda, Long> {
    Optional<Agenda> findAgendaByNombre(String nombre);
}
