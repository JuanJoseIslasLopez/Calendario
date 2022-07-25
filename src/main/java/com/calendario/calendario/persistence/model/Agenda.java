package com.calendario.calendario.persistence.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    @Column (name = "fecha")
    private Date fecha;

    public Agenda() {
    }

    public Agenda(Integer id, Usuario usuario, Date fecha) {
        this.id = id;
        this.usuario = usuario;
        this.fecha = fecha;
    }

    public Agenda(Usuario usuario, Date fecha) {
        this.usuario = usuario;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                "id=" + id +
                ", usuario=" + usuario +
                ", fecha=" + fecha +
                '}';
    }
}
