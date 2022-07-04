package com.calendario.calendario.persistence.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class TipoUsuario {
        @Id
        @SequenceGenerator(
                name = "tipousuario_sequence",
                sequenceName = "tipousuario_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "tipousuario_sequence"
        )
        @Column
        private Integer id;
        @Column
        private String nombre;
        @Column
        private List<Permisos> permisosList;

    public TipoUsuario() {
    }

    public TipoUsuario(Integer id,
                       String nombre,
                       List<Permisos> permisosList) {
        this.id = id;
        this.nombre = nombre;
        this.permisosList = permisosList;
    }

    public TipoUsuario(String nombre,
                       List<Permisos> permisosList) {
        this.nombre = nombre;
        this.permisosList = permisosList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Permisos> getPermisosList() {
        return permisosList;
    }

    public void setPermisosList(List<Permisos> permisosList) {
        this.permisosList = permisosList;
    }

    @Override
    public String toString() {
        return "TipoUsuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", permisosList=" + permisosList +
                '}';
    }
}
