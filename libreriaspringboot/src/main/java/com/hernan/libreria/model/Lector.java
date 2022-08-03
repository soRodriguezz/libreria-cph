package com.hernan.libreria.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class Lector {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;


    private String nombre ;
    private String apellido;
    private String direcion;
    private String dni;

    @OneToMany(mappedBy = "lector")
    private List<Prestamo> pretamos;



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Prestamo> getPretamos() {
        return pretamos;
    }

    public void setPretamos(List<Prestamo> pretamos) {
        this.pretamos = pretamos;
    }
}
