package com.calendario.calendario.persistence.repository;

import com.calendario.calendario.persistence.model.Agenda;
import com.calendario.calendario.persistence.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryAgenda
        extends JpaRepository<Agenda, Long> {

    Optional<Agenda> findAgendaByUsuario(Usuario usuario);
}
