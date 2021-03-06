package com.calendario.calendario.domain.servicio;

import com.calendario.calendario.persistence.model.Permisos;
import com.calendario.calendario.persistence.repository.RepositoryPermisos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ServiciosPermisos {

    private final RepositoryPermisos repositoryPermisos;

    @Autowired
    public ServiciosPermisos(RepositoryPermisos repositoryPermisos){this.repositoryPermisos= repositoryPermisos;}

    public List<Permisos> getPermisos() {return repositoryPermisos.findAll();}

    public void addNewPermisos(Permisos permisos) {
        Optional<Permisos> permisosOptional = repositoryPermisos
                .findPermisosByNombre(permisos.getNombre());
        if(permisosOptional.isPresent()){
            throw new IllegalStateException("nombre taken");
        }
        repositoryPermisos.save(permisos);
    }

    public Permisos deletePermisos(Permisos permisos) {
//        boolean exists = repositoryPermisos.existsById(permisos);
//        if (!exists) {
//            throw new IllegalStateException(
//                    "permisos with id" + permisosId + "does not exists");
//        }
       repositoryPermisos.delete(permisos);
        return permisos;
    }

    @Transactional
    public Permisos updatePermisos (Permisos permisos) {
        return repositoryPermisos.save(permisos);
//        Permisos permisos = repositoryPermisos.findById(permisosId)
//                .orElseThrow(() -> new IllegalStateException(
//                        " permiso with id " +permisosId+ " does not exist "));
//
//        if (name != null &&
//                name.length() > 0 &&
//                !Objects.equals(permisos.getNombre(), name)) {
//            permisos.setNombre(name);
//        }
    }
}
