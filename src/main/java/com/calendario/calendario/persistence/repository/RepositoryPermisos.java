package com.calendario.calendario.persistence.repository;

import com.calendario.calendario.persistence.model.Permisos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryPermisos
    extends JpaRepository<Permisos, Long> {

        Optional<Permisos> findPermisosByNombre(String nombre);
    }
