package com.calendario.calendario.persistence.model;

import javax.persistence.*;

@Entity
@Table
public class Usuario {
    @Id
    @SequenceGenerator(
            name = "usuario_sequence",
            sequenceName = "usuario_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "usuario_sequence"
    )
    @Column
    private Integer id;
    @Column
    private String nombre;
    @Column
    private String telefono;
    @Column
    private String direccion;
    @Column
    private TipoUsuario tipoUsuario;

    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String telefono, String direccion, TipoUsuario tipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(String nombre,
                   String telefono,
                   String direccion,
                   TipoUsuario tipoUsuario) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tipoUsuario = tipoUsuario;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                '}';
    }
}
