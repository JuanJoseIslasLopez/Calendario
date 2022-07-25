package com.calendario.calendario.persistence.repository;

import com.calendario.calendario.persistence.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryUsuario
        extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findUsuarioByNombre(String nombre);
}
