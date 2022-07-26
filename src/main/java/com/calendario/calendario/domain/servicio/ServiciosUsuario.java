package com.calendario.calendario.domain.servicio;

import com.calendario.calendario.persistence.model.Usuario;
import com.calendario.calendario.persistence.repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ServiciosUsuario {

    private final RepositoryUsuario repositoryUsuario;

    @Autowired
    public ServiciosUsuario(RepositoryUsuario repositoryUsuario){this.repositoryUsuario= repositoryUsuario;}

    public List<Usuario> getUsuario() {return repositoryUsuario.findAll();}

    public void addNewUsuario(Usuario usuario) {
        Optional<Usuario> usuarioOptional = repositoryUsuario
                .findUsuarioByNombre(usuario.getNombre());
        if(usuarioOptional.isPresent()){
            throw new IllegalStateException("nombre taken");
        }
        repositoryUsuario.save(usuario);
    }

    public void deleteUsuario(Long usuarioId) {
        boolean exists = repositoryUsuario.existsById(usuarioId);
        if (!exists) {
            throw new IllegalStateException(
                    "usuario with id" + usuarioId + "does not exists");
        }
        repositoryUsuario.deleteById(usuarioId);
    }

    @Transactional
    public void updateUsuario(Long usuarioId,
                               String name) {
        Usuario usuario = repositoryUsuario.findById(usuarioId)
                .orElseThrow(() -> new IllegalStateException(
                        " usuario with id " +usuarioId+ " does not exist "));

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(usuario.getNombre(), name)) {
            usuario.setNombre(name);
        }
    }
}
