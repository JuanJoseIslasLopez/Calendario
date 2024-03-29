package com.calendario.calendario.domain.servicio;

import com.calendario.calendario.persistence.model.TipoUsuario;
import com.calendario.calendario.persistence.repository.RepositoryTipoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ServiciosTipoUsuario {
    private final RepositoryTipoUsuario repositoryTipoUsuario;

    @Autowired
    public ServiciosTipoUsuario(RepositoryTipoUsuario repositoryTipoUsuario){this.repositoryTipoUsuario= repositoryTipoUsuario;}

    public List<TipoUsuario> getTipoUsuario() {return repositoryTipoUsuario.findAll();}

    public void addNewTipoUsuario(TipoUsuario tipoUsuario) {
//        Optional<TipoUsuario> tipoUsuarioOptional = repositoryTipoUsuario
//                .findTipoUsuarioByNombre(tipoUsuario.getNombre());
//        if(tipoUsuarioOptional.isPresent()){
//            throw new IllegalStateException("nombre taken");
//        }
        repositoryTipoUsuario.save(tipoUsuario);
    }

    public TipoUsuario deleteTipoUsuario(TipoUsuario tipoUsuario) {
//        boolean exists = repositoryTipoUsuario.existsById(tipoUsuarioId);
//        if (!exists) {
//            throw new IllegalStateException(
//                    "tipousuario with id" + tipoUsuarioId + "does not exists");
//        }
        repositoryTipoUsuario.delete(tipoUsuario);
        return tipoUsuario;
    }

    @Transactional
    public TipoUsuario updateTipoUsuario (TipoUsuario tipoUsuario) {
        return repositoryTipoUsuario.save(tipoUsuario);
//        TipoUsuario tipoUsuario = repositoryTipoUsuario.findById(tipousuarioId)
//                .orElseThrow(() -> new IllegalStateException(
//                        " tipousuario with id " +tipousuarioId+ " does not exist "));
//
//        if (name != null &&
//                name.length() > 0 &&
//                !Objects.equals(tipoUsuario.getNombre(), name)) {
//            tipoUsuario.setNombre(name);
//        }
    }
}
