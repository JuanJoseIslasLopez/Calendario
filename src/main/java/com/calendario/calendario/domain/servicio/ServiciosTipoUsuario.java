package com.calendario.calendario.domain.servicio;

import com.calendario.calendario.persistence.model.TipoUsuario;
import com.calendario.calendario.persistence.repository.RepositoryTipoUsuario;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

public class ServiciosTipoUsuario {
    private final RepositoryTipoUsuario repositoryTipoUsuario;

    @Autowired
    public ServiciosTipoUsuario(RepositoryTipoUsuario repositoryTipoUsuario){this.repositoryTipoUsuario= repositoryTipoUsuario;}

    public List<TipoUsuario> getTipousuario() {return repositoryTipoUsuario.findAll();}

    public void addNewTipousuario(TipoUsuario tipoUsuario) {
//        Optional<TipoUsuario> tipoUsuarioOptional = repositoryTipoUsuario
//                .findTipoUsuarioByNombre(tipousuario.getNombre());
//        if(tipoUsuarioOptional.isPresent()){
//            throw new IllegalStateException("nombre taken");
//        }
        repositoryTipoUsuario.save(tipoUsuario);
    }

    public void deleteTipousuario(Long tipousuarioId) {
        boolean exists = repositoryTipoUsuario.existsById(tipousuarioId);
        if (!exists) {
            throw new IllegalStateException(
                    "tipousuario with id" + tipousuarioId + "does not exists");
        }
        repositoryTipoUsuario.deleteById(tipousuarioId);
    }

    @Transactional
    public void updateTipousuario(Long tipousuarioId,
                               String name) {
        TipoUsuario tipoUsuario = repositoryTipoUsuario.findById(tipousuarioId)
                .orElseThrow(() -> new IllegalStateException(
                        " tipousuario with id " +tipousuarioId+ " does not exist "));

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(tipoUsuario.getNombre(), name)) {
            tipoUsuario.setNombre(name);
        }
    }
}
