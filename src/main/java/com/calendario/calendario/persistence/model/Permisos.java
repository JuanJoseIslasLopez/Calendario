package com.calendario.calendario.persistence.model;

import javax.persistence.*;

@Entity
@Table
public class Permisos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nombre;

    public Permisos() {
    }

    public Permisos(Integer id,
                    String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Permisos(String nombre) {
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "Permisos{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}





