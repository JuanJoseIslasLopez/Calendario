package com.calendario.calendario.domain.servicio;

import com.calendario.calendario.persistence.model.Agenda;
import com.calendario.calendario.persistence.model.TipoUsuario;
import com.calendario.calendario.persistence.model.Usuario;
import com.calendario.calendario.persistence.repository.RepositoryAgenda;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

public class ServiciosAgenda {
    private final RepositoryAgenda repositoryAgenda;

    @Autowired
    public ServiciosAgenda(RepositoryAgenda repositoryAgenda){this.repositoryAgenda= repositoryAgenda;}

    public List<Agenda> getAgenda() {return repositoryAgenda.findAll();}

    public void addNewAgenda(Agenda agenda) {
//        Optional<TipoUsuario> tipoUsuarioOptional = repositoryTipoUsuario
//                .findTipoUsuarioByNombre(tipousuario.getNombre());
//        if(tipoUsuarioOptional.isPresent()){
//            throw new IllegalStateException("nombre taken");
//        }
        repositoryAgenda.save(agenda);
    }

    public void deleteAgenda(Long agendaId) {
        boolean exists = repositoryAgenda.existsById(agendaId);
        if (!exists) {
            throw new IllegalStateException(
                    "agenda with id" + agendaId + "does not exists");
        }
        repositoryAgenda.deleteById(agendaId);
    }

    @Transactional
    public void updateAgenda(Long agendaId,
                             String name) {
        Agenda agenda = repositoryAgenda.findById(agendaId)
                .orElseThrow(() -> new IllegalStateException(
                        " agenda with id " +agendaId+ " does not exist "));

//        if (name != null &&
//                name.length() > 0 &&
//                !Objects.equals(agenda.getUsuario(), name)) {
//            agenda.setUsuario(name);
//        }

    }
}
