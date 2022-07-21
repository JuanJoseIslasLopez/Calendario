package com.calendario.calendario.persistence.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Agenda {
    @Id
    @SequenceGenerator(
            name = "agenda_sequence",
            sequenceName = "agenda_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "agenda_sequence"
    )
    @Column
    private Usuario usuario;
    @Column
    private Date fecha;

    public Agenda() {
    }

    public Agenda(Usuario usuario, Date fecha) {
        this.usuario = usuario;
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "usuario=" + usuario +
                ", fecha=" + fecha +
                '}';
    }
}
