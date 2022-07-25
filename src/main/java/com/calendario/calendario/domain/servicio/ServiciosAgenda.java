package com.calendario.calendario.domain.servicio;

import com.calendario.calendario.persistence.model.Agenda;
import com.calendario.calendario.persistence.model.Usuario;
import com.calendario.calendario.persistence.repository.RepositoryAgenda;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ServiciosAgenda {
    private final RepositoryAgenda repositoryAgenda;

    @Autowired
    public ServiciosAgenda(RepositoryAgenda repositoryAgenda){this.repositoryAgenda= repositoryAgenda;}

    public List<Agenda> getAgenda() {return repositoryAgenda.findAll();}

    public Agenda saveAgenda(Agenda agenda) {
        return repositoryAgenda.save(agenda);
//        Optional<Agenda> usuarioOptional = repositoryAgenda
//                .findAgendaByUsuario(agenda.getUsuario());
//        if(usuarioOptional.isPresent()){
//            throw new IllegalStateException("Agenda taken");
//        }
//        repositoryAgenda.save(agenda);
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
    public Agenda updateAgenda(Agenda agenda) throws Exception {
        if (agenda.getId()!=null) {
            return repositoryAgenda.save(agenda);
        } else {
            throw new Exception("ID nulo");
        }

               /* .orElseThrow(() -> new IllegalStateException(
                        " agenda with id " +agendaId+ " does not exist "));*/

/*        if (usuario != null &&
                usuario.length() > 0 &&
                !Objects.equals(agenda.getUsuario(), usuario)) {
            agenda.setUsuario(usuario);*/
       /* }*/
    }
}
