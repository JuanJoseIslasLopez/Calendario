package com.calendario.calendario.persistence.repository;

import com.calendario.calendario.persistence.model.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryTipoUsuario
        extends JpaRepository<TipoUsuario, Long> {
    TipoUsuario findByNombre(String nombre);
}
